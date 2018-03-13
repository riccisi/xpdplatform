package it.tasgroup.xtderp.xtdplatform.infrastructure.media.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public abstract class JsonRendered implements Rendered<JsonNode> {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public final void writeOn(OutputStream stream) throws IOException {
        this.mapper.writeValue(stream, this.value());
    }
}