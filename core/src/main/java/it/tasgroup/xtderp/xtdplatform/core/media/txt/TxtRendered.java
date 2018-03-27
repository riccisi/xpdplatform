package it.tasgroup.xtderp.xtdplatform.core.media.txt;

import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;

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
    public final void writeOn(OutputStream stream) throws Exception {
        new OutputStreamWriter(stream).write(this.value());
    }
}