package it.tasgroup.xtderp.xtdplatform.core.media.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
abstract class JsonRendered implements Rendered<JsonNode> {

    @Override
    public final void writeOn(OutputStream stream) throws Exception {
        new ObjectMapper().writeValue(stream, this.value());
    }
}