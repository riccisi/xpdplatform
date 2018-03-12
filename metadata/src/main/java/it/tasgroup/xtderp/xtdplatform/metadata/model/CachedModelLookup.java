package it.tasgroup.xtderp.xtdplatform.metadata.model;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class CachedModelLookup implements ModelLookup {

    private final ModelLookup delegate;

    private final Map<String, Model> cache = new HashMap<>();

    @Override
    public Model get(String modelId) {
        return this.cache.computeIfAbsent(modelId, s -> delegate.get(modelId));
    }
}
