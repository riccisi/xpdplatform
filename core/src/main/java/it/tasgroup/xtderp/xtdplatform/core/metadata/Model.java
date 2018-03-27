package it.tasgroup.xtderp.xtdplatform.core.metadata;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface Model extends Printable {

    /**
     * Fake {@link Model} implementation class for testing purpose.
     */
    @RequiredArgsConstructor
    @ToString
    @EqualsAndHashCode
    final class Fake implements Model {

        private final String prop;
        private final String value;

        public Fake() {
            this("prop","value");
        }

        @Override
        public <R> Rendered<R> print(Media<R> media) throws Exception {
            return media.asObject().with(this.prop,this.value);
        }
    }
}