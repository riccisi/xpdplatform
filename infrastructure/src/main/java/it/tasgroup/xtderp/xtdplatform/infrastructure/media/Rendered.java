package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface Rendered {

    Rendered EMPTY = stream -> {};

    void writeOn(OutputStream stream) throws IOException;
}
