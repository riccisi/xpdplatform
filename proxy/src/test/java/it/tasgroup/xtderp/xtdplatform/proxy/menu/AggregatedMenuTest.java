package it.tasgroup.xtderp.xtdplatform.proxy.menu;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Action;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Result;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.ConfigurableMenu;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.Menu;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.MenuBuilder;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.MenuConfigurer;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.MenuFolder;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.MenuItem;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.MenuNode;
import lombok.RequiredArgsConstructor;
import org.junit.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.Assert.*;

public class AggregatedMenuTest {

    @Test
    public void test() {
        AggregatedMenu menu = new AggregatedMenu(new TestMenus());

        Iterator<MenuNode> miterator = menu.iterator();
        MenuNode a = miterator.next();
        assertEquals("a", a.code());
        assertTrue(MenuFolder.class.isAssignableFrom(a.getClass()));

        Iterator<MenuNode> aiterator = ((MenuFolder) a).iterator();
        MenuNode b = aiterator.next();
        MenuNode e = aiterator.next();
        assertEquals("a.b", b.code());
        assertTrue(MenuFolder.class.isAssignableFrom(b.getClass()));
        assertEquals("a.e", e.code());
        assertTrue(MenuItem.class.isAssignableFrom(e.getClass()));

        Iterator<MenuNode> biterator = ((MenuFolder) b).iterator();
        MenuNode c = biterator.next();
        MenuNode d = biterator.next();
        MenuNode f = biterator.next();
        assertEquals("a.b.c", c.code());
        assertTrue(MenuItem.class.isAssignableFrom(c.getClass()));
        assertEquals("a.b.d", d.code());
        assertTrue(MenuItem.class.isAssignableFrom(d.getClass()));
        assertEquals("a.b.f", f.code());
        assertTrue(MenuItem.class.isAssignableFrom(f.getClass()));

        MenuNode g = miterator.next();
        assertEquals("g", g.code());
        assertTrue(MenuFolder.class.isAssignableFrom(g.getClass()));

        Iterator<MenuNode> giterator = ((MenuFolder) g).iterator();
        MenuNode h = giterator.next();
        assertEquals("g.h", h.code());
        assertTrue(MenuFolder.class.isAssignableFrom(h.getClass()));

        Iterator<MenuNode> hiterator = ((MenuFolder) h).iterator();
        MenuNode i = hiterator.next();
        assertEquals("g.h.i", i.code());
        assertTrue(MenuItem.class.isAssignableFrom(i.getClass()));
    }

    private class TestMenus implements Menus {

        @Override
        public Iterator<Menu> iterator() {
            List<Menu> menus = new ArrayList<>();
            menus.add(new ConfigurableMenu(singletonList(new TestMenuConfigurer1())));
            menus.add(new ConfigurableMenu(singletonList(new TestMenuConfigurer2())));
            return menus.iterator();
        }
    }

    private class TestMenuConfigurer1 implements MenuConfigurer {

        @Override
        public void configure(MenuBuilder builder) {
            builder.add("a.b.c", new MockAction("f1"));
            builder.add("a.b.d", new MockAction("f2"));
            builder.add("a.e", new MockAction("f3"));
        }
    }

    private class TestMenuConfigurer2 implements MenuConfigurer {

        @Override
        public void configure(MenuBuilder builder) {
            builder.add("a.b.f", new MockAction("f4"));
            builder.add("g.h.i", new MockAction("f5"));
        }
    }

    @RequiredArgsConstructor
    class MockAction implements Action {

        private final String id;

        @Override
        public Result execute(Request request) throws Exception {
            return Result.EMPTY;
        }

        @Override
        public String id() {
            return null;
        }

        @Override
        public void print(Media media) {
            throw new UnsupportedOperationException("#print()");
        }
    }
}