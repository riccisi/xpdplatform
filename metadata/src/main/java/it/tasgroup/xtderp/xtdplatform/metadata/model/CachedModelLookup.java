package it.tasgroup.xtderp.xtdplatform.metadata.model;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class CachedModelLookup implements ModelLookup {

    private final ModelLookup delegate;

    private final Map<String, ModelMetadata> cache = new HashMap<>();

    @Override
    public ModelMetadata get(String modelId) {
        return this.cache.computeIfAbsent(modelId, s -> delegate.get(modelId));
    }
}
