package it.tasgroup.xtderp.xtdplatform.core.metadata;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
public interface Entity extends Model {

    void save() throws Exception;

    void delete() throws Exception;

    /**
     * Fake {@link Entity} implementation class for testing purpose.
     */
    @RequiredArgsConstructor
    @ToString
    @EqualsAndHashCode
    final class Fake implements Entity {

        private final Model model;

        public Fake() {
            this(new Model.Fake());
        }

        @Override
        public void save() throws Exception {
            // do nothing
        }

        @Override
        public void delete() throws Exception {
            // do nothing
        }

        @Override
        public <R> Rendered<R> print(Media<R> media) throws Exception {
            return this.model.print(media);
        }
    }
}