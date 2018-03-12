package it.tasgroup.xtderp.xtdplatform.metadata.model;

import it.tasgroup.xtderp.xtdplatform.infrastructure.util.CachedIterable;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CachedModel extends CachedIterable<Attribute> implements Model {

    private final Model delegate;

    private String id;

    @Override
    public String id() {
        if(this.id == null) {
            this.id = this.delegate.id();
        }
        return id;
    }

    @Override
    public ProcessedModel process() {
        return this.delegate.process();
    }

    @Override
    protected Iterable<Attribute> iterable() {
        return this.delegate;
    }
}