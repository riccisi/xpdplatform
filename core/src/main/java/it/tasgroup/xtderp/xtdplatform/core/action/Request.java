package it.tasgroup.xtderp.xtdplatform.core.action;

import org.cactoos.text.TextOf;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface Request {

    InputStream body() throws IOException;

    default String asString() throws IOException {
       return new TextOf(this.body()).asString();
    }
}