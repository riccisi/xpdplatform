package it.tasgroup.xtderp.xtdplatform.core.menu.model;

import org.cactoos.iterable.StickyIterable;

import java.util.Iterator;

/**
 * Decorator of a Menu (delegate) that caches subsequent calls to the iterator method.
 */
public final class CachedMenu implements Menu {

    private final StickyIterable<MenuNode> cache;

    public CachedMenu(Menu delegate) {
        this.cache = new StickyIterable<>(delegate);
    }

    @Override
    public Iterator<MenuNode> iterator() {
        return this.cache.iterator();
    }
}