package it.tasgroup.xtderp.xtdplatform.core.metadata;

import lombok.RequiredArgsConstructor;
import org.cactoos.iterable.Filtered;
import org.cactoos.scalar.ItemAt;

@RequiredArgsConstructor
public final class DefaultMetadataLookup implements MetadataLookup {

    private final Metadata metadata;

    @Override
    public ModelMetadata get(final String id) throws Exception {
        return new ItemAt<>(
            0,
            new Filtered<>(
                model -> model.id().equals(id),
                this.metadata
            )
        ).value();
    }
}