package it.tasgroup.xtderp.xtdplatform.core.action;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface Output {

    void ofType(String type);

    OutputStream stream() throws IOException;

    default Writer writer() throws IOException {
        return new OutputStreamWriter(this.stream());
    }
}