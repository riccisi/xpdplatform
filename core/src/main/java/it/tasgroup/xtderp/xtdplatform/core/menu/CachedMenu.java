package it.tasgroup.xtderp.xtdplatform.core.menu;

import org.cactoos.iterable.StickyIterable;

import java.util.Iterator;

/**
 * Decorator of a Menu (delegate) that caches subsequent calls to the iterator method.
 *
 * <p>The class is immutable and thread-safe.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
public final class CachedMenu implements Menu {

    private final StickyIterable<MenuNode> cache;

    public CachedMenu(final Menu delegate) {
        this.cache = new StickyIterable<>(delegate);
    }

    @Override
    public Iterator<MenuNode> iterator() {
        return this.cache.iterator();
    }
}