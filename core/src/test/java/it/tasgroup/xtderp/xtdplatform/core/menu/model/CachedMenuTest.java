package it.tasgroup.xtderp.xtdplatform.core.menu.model;

import org.junit.Test;

import java.util.Iterator;

import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CachedMenuTest {

    @Test
    public void test() throws Exception {
        Menu menu = new CachedMenu(new MockMenu());
        MenuNode firstIteratorCall = menu.iterator().next();
        assertThat("subsequent iterator calls", firstIteratorCall, equalTo(menu.iterator().next()));
    }

    @Test
    public void iterator() throws Exception {
    }

    private class MockMenu implements Menu {

        @Override
        public Iterator<MenuNode> iterator() {
            return singletonList((MenuNode)new MockMenuNode()).iterator();
        }
    }

    private class MockMenuNode implements MenuNode {

        @Override
        public String code() {
            return "test";
        }

        @Override
        public void accept(MenuNodeVisitor visitor) {
        }
    }
}