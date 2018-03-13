package it.tasgroup.xtderp.xtdplatform.metadata.model;

import it.tasgroup.xtderp.xtdplatform.infrastructure.util.CachedIterable;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CachedModels extends CachedIterable<ModelMetadata> implements Models {

    private final Models models;

    @Override
    protected Iterable<ModelMetadata> iterable() {
        return this.models;
    }
}
