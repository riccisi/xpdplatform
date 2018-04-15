package it.tasgroup.xtderp.xtdplatform.core.metadata;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cactoos.iterator.Filtered;
import org.cactoos.iterator.Mapped;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class Fields implements Iterable<Field> {

    @NonNull private final ModelMetadata<?> metadata;

    @Override
    public Iterator<Field> iterator() {
        return
            new Mapped<>(
                Field.class::cast,
                new Filtered<>(
                    input -> Field.class.isAssignableFrom(input.getClass()),
                    this.metadata.iterator()
                )
            );
    }
}