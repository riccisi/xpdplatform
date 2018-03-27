package it.tasgroup.xtderp.xtdplatform.core.menu.model;

import it.tasgroup.xtderp.xtdplatform.core.action.Action;
import org.junit.Test;

import java.util.Iterator;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

public class ConfigurableMenuTest {

    @Test
    public void iterator() throws Exception {
        Menu menu = new ConfigurableMenu(singletonList(new TestMenuConfigurer()));

        MenuNode a = menu.iterator().next();
        assertEquals("a", a.code());
        assertEquals(DefaultMenuFolder.class, a.getClass());

        Iterator<MenuNode> iterator = ((MenuFolder) a).iterator();
        MenuNode b = iterator.next();
        MenuNode z = iterator.next();
        assertEquals("a.b", b.code());
        assertEquals(DefaultMenuFolder.class, b.getClass());
        assertEquals("a.z", z.code());
        assertEquals(DefaultMenuFolder.class, z.getClass());

        iterator = ((MenuFolder) b).iterator();
        MenuNode c = iterator.next();
        MenuNode d = iterator.next();
        MenuNode e = iterator.next();
        assertEquals("a.b.c", c.code());
        assertEquals(DefaultMenuItem.class, c.getClass());
        assertEquals("a.b.d", d.code());
        assertEquals(DefaultMenuItem.class, d.getClass());
        assertEquals("a.b.e", e.code());
        assertEquals(DefaultMenuItem.class, e.getClass());

        MenuNode x =  ((MenuFolder) z).iterator().next();
        assertEquals("a.z.x", x.code());
        assertEquals(DefaultMenuItem.class, x.getClass());
    }

    private class TestMenuConfigurer implements MenuConfigurer {

        @Override
        public void configure(MenuBuilder menuBuilder) {
            menuBuilder.add("a.b.c", new Action.Fake("abc"));
            menuBuilder.add("a.b.d", new Action.Fake("abd"));
            menuBuilder.add("a.b.e", new Action.Fake("abe"));
            menuBuilder.add("a.z.x", new Action.Fake("azx"));
        }
    }
}