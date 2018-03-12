package it.tasgroup.xtderp.xtdplatform.infrastructure.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class CachedIterable<T> implements Iterable<T>  {

    private List<T> cache;

    @Override
    public Iterator<T> iterator() {
        if(this.cache == null) {
            this.cache = new ArrayList<>();
            this.iterable().forEach(this.cache::add);
        }
        return this.cache.iterator();
    }

    protected abstract Iterable<T> iterable();
}
