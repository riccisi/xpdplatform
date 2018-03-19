package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface Rendered<T> {

    T value();

    void writeOn(OutputStream stream) throws IOException;

    /**
     * Fake Rendered implementation class for testing purpose.
     */
    final class Fake implements Rendered<String> {

        private String value;

        @Override
        public String value() {
            return this.value;
        }

        @Override
        public void writeOn(OutputStream stream) throws IOException {
            new OutputStreamWriter(stream).write(this.value);
        }
    }
}
