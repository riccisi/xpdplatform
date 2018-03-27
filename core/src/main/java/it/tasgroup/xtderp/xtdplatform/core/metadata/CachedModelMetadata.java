package it.tasgroup.xtderp.xtdplatform.core.metadata;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import org.cactoos.iterable.StickyIterable;
import org.cactoos.scalar.StickyScalar;

import java.util.Iterator;

/**
 *
 */
public class CachedModelMetadata implements ModelMetadata {

    private final ModelMetadata delegate;
    private final StickyIterable<Attribute> cache;
    private final StickyScalar<String> cachedId;

    public CachedModelMetadata(ModelMetadata delegate) {
        this.delegate = delegate;
        this.cache = new StickyIterable<>(delegate);
        this.cachedId = new StickyScalar<>(delegate::id);
    }

    @Override
    public String id() throws Exception {
       return cachedId.value();
    }

    @Override
    public <T> Rendered<T> print(Media<T> media) throws Exception {
        return this.delegate.print(media);
    }

    @Override
    public Iterator<Attribute> iterator() {
        return this.cache.iterator();
    }

    @Override
    public Model newInstance() throws Exception {
        return this.delegate.newInstance();
    }
}