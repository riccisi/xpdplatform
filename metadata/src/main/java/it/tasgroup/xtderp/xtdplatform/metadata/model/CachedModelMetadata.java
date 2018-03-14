package it.tasgroup.xtderp.xtdplatform.metadata.model;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.infrastructure.util.CachedIterable;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CachedModelMetadata extends CachedIterable<Attribute> implements ModelMetadata {

    private final ModelMetadata delegate;

    private String id;

    @Override
    public String id() {
        if(this.id == null) {
            this.id = this.delegate.id();
        }
        return id;
    }

    @Override
    protected Iterable<Attribute> iterable() {
        return this.delegate;
    }

    @Override
    public <T> Rendered<T> print(Media<T> media) {
        return this.delegate.print(media);
    }
}