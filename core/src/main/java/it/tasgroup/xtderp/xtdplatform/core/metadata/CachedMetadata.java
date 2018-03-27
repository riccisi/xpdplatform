package it.tasgroup.xtderp.xtdplatform.core.metadata;

import org.cactoos.iterable.StickyIterable;

import java.util.Iterator;

public class CachedMetadata implements Metadata {

    private final StickyIterable<ModelMetadata> cache;

    public CachedMetadata(Metadata metadata) {
        this.cache = new StickyIterable<>(metadata);
    }

    @Override
    public Iterator<ModelMetadata> iterator() {
        return this.cache.iterator();
    }
}
