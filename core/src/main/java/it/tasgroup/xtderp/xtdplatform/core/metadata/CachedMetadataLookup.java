package it.tasgroup.xtderp.xtdplatform.core.metadata;

import lombok.RequiredArgsConstructor;
import org.cactoos.func.UncheckedFunc;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class CachedMetadataLookup implements MetadataLookup {

    private final MetadataLookup delegate;

    private final Map<String, ModelMetadata> cache = new HashMap<>();

    @Override
    public ModelMetadata get(String modelId) {
        return this.cache.computeIfAbsent(modelId, id -> new UncheckedFunc<>(delegate::get).apply(id));
    }
}
