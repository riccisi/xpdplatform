package it.tasgroup.xtderp.xtdplatform.core.metadata;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.cactoos.list.ListOf;

import java.util.Iterator;

public interface EntityMetadata extends ModelMetadata {

    @Override
    Entity newInstance() throws Exception;

    /**
     * Fake {@link EntityMetadata} implementation class for testing purpose.
     */
    @RequiredArgsConstructor
    @ToString
    @EqualsAndHashCode
    final class Fake implements EntityMetadata {

        private final String id;

        public Fake() {
            this("FakeEntity");
        }

        @Override
        public Entity newInstance() {
            return new Entity.Fake();
        }

        @Override
        public <R> Rendered<R> print(final Media<R> media) {
            return media.asObject()
                .with("id",this.id)
                .with("type","entity");
        }

        @Override
        public String id() {
            return this.id;
        }

        @Override
        public Iterator<Attribute> iterator() {
            return new ListOf<Attribute>(new Field.Fake()).iterator();
        }
    }

}