package it.tasgroup.xtderp.xtdplatform.core.metadata;

import lombok.RequiredArgsConstructor;
import org.cactoos.iterable.Filtered;
import org.cactoos.iterable.ItemAt;

@RequiredArgsConstructor
public class DefaultMetadataLookup implements MetadataLookup {

    private final Metadata metadata;

    @Override
    public ModelMetadata get(String modelId) throws Exception {
        return new ItemAt<>(
            0,
            new Filtered<>(
                model -> model.id().equals(modelId),
                this.metadata
            )
        ).value();
    }
}