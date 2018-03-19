package it.tasgroup.xtderp.xtdplatform.infrastructure.media.txt;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
abstract class TxtRendered implements Rendered<String> {

    @Override
    public final void writeOn(OutputStream stream) throws IOException {
        new OutputStreamWriter(stream).write(this.value());
    }
}