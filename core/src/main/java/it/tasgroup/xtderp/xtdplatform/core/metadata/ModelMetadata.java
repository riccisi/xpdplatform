package it.tasgroup.xtderp.xtdplatform.core.metadata;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.core.util.Identified;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.cactoos.list.ListOf;

import java.util.Iterator;

public interface ModelMetadata<T> extends Iterable<Attribute>, Identified, Printable {

    Model<T> newInstance() throws Exception;

    /**
     * Fake {@link ModelMetadata} implementation class for testing purpose.
     */
    @RequiredArgsConstructor
    @ToString
    @EqualsAndHashCode
    final class Fake implements ModelMetadata<Model.Fake> {

        private final String id;

        public Fake() {
            this("fakeModel");
        }

        @Override
        public Model<Model.Fake> newInstance() {
            return new Model.Fake();
        }

        @Override
        public <R> Rendered<R> print(final Media<R> media) {
            return media.asObject()
                .with("id",this.id)
                .with("type","model");
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