package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface Rendered<T> {

    Rendered<Optional> EMPTY = new Rendered<Optional>() {
        @Override
        public Optional value() {
            return Optional.empty();
        }

        @Override
        public void writeOn(OutputStream stream) {
        }
    };

    T value();

    void writeOn(OutputStream stream) throws IOException;
}
