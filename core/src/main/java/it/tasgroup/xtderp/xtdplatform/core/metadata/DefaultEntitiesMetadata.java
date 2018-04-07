package it.tasgroup.xtderp.xtdplatform.core.metadata;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cactoos.iterator.Filtered;
import org.cactoos.iterator.Mapped;

import java.util.Iterator;

/**
 * <p>Default {@link EntitiesMetadata} implementation that iterate only over {@link EntityMetadata}.</p>
 *
 * <p>The class is immutable and thread-safe.</p>
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class DefaultEntitiesMetadata implements EntitiesMetadata {

    @NonNull private final Metadata metadata;

    @Override
    @SuppressWarnings("rawtypes")
    public Iterator<EntityMetadata> iterator() {
        return
            new Mapped<>(
                EntityMetadata.class::cast,
                new Filtered<>(
                    input -> EntityMetadata.class.isAssignableFrom(input.getClass()),
                    this.metadata.iterator()
                )
            );
    }
}