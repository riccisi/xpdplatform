package it.tasgroup.xtderp.xtdplatform.core.media;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface Rendered<T> {

    T value() throws Exception;

    void writeOn(OutputStream stream) throws Exception;
}
