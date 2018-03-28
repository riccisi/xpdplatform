package it.tasgroup.xtderp.xtdplatform.core.metadata;

import lombok.RequiredArgsConstructor;
import org.cactoos.func.UncheckedFunc;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public final class CachedMetadataLookup implements MetadataLookup {

    private final MetadataLookup delegate;

    private final Map<String, ModelMetadata> cache = new HashMap<>(0);

    @Override
    public ModelMetadata get(final String modelId) {
        return this.cache.computeIfAbsent(modelId, id -> new UncheckedFunc<>(this.delegate::get).apply(id));
    }
}
