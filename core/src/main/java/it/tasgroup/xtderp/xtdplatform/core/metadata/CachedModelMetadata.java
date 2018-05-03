package it.tasgroup.xtderp.xtdplatform.core.metadata;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import org.cactoos.iterable.StickyIterable;
import org.cactoos.scalar.StickyScalar;
import org.cactoos.scalar.UncheckedScalar;

import java.util.Iterator;

/**
 *
 */
public final class CachedModelMetadata<T> implements ModelMetadata<T> {

    private final ModelMetadata<T> delegate;
    private final Iterable<Attribute> cache;
    private final UncheckedScalar<String> cachedId;

    public CachedModelMetadata(final ModelMetadata<T> delegate) {
        this.delegate = delegate;
        this.cache = new StickyIterable<>(delegate);
        this.cachedId = new UncheckedScalar<>(new StickyScalar<>(delegate::id));
    }

    @Override
    public String id() {
       return this.cachedId.value();
    }

    @Override
    public <R> Rendered<R> print(final Media<R> media) throws Exception {
        return this.delegate.print(media);
    }

    @Override
    public Iterator<Attribute> iterator() {
        return this.cache.iterator();
    }

    @Override
    public Model<T> newInstance() throws Exception {
        return this.delegate.newInstance();
    }
}