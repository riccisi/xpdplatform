package it.tasgroup.xtderp.xtdplatform.core.action;

import org.cactoos.iterable.StickyIterable;

import java.util.Iterator;

public class CachedActions implements Actions {

    private final StickyIterable<Action> cache;

    public CachedActions(Actions delegate) {
        this.cache = new StickyIterable<>(delegate);
    }

    @Override
    public Iterator<Action> iterator() {
        return this.cache.iterator();
    }
}