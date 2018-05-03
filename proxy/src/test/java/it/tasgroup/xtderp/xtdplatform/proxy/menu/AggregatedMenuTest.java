package it.tasgroup.xtderp.xtdplatform.proxy.menu;

import org.junit.Test;

public final class AggregatedMenuTest {

    @Test
    public void test() {
        /*AggregatedMenu menu = new AggregatedMenu(new TestMenus());

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
        assertTrue(MenuItem.class.isAssignableFrom(i.getClass()));*/
    }

   /* private class TestMenus implements Menus {

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
            builder.add("a.b.c", new Action.Fake("f1"));
            builder.add("a.b.d", new Action.Fake("f2"));
            builder.add("a.e", new Action.Fake("f3"));
        }
    }

    private class TestMenuConfigurer2 implements MenuConfigurer {

        @Override
        public void configure(MenuBuilder builder) {
            builder.add("a.b.f", new Action.Fake("f4"));
            builder.add("g.h.i", new Action.Fake("f5"));
        }
    }*/
}