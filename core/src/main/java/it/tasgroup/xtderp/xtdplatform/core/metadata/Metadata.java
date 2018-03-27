package it.tasgroup.xtderp.xtdplatform.core.metadata;

import lombok.RequiredArgsConstructor;
import org.cactoos.list.ListOf;

import java.util.Iterator;
import java.util.List;

public interface Metadata extends Iterable<ModelMetadata> {

    /**
     * Fake {@link Metadata} implementation class for testing purpose.
     */
    @RequiredArgsConstructor
    final class Fake implements Metadata {

        private final List<ModelMetadata> metadata;

        public Fake(ModelMetadata... metadata) {
            this(new ListOf<>(metadata));
        }

        @Override
        public Iterator<ModelMetadata> iterator() {
            return this.metadata.iterator();
        }
    }
}