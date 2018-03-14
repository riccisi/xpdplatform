package it.tasgroup.xtderp.xtdplatform.infrastructure.media.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Printable;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.json.JsonMedia;

import java.io.IOException;

/**
 * Custom Jackson {@link JsonSerializer} to serialize a {@link Printable} using the {@link Media} API.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class PrintableJsonSerializer extends JsonSerializer<Printable> {

    @Override
    public void serialize(Printable printable, JsonGenerator gen, SerializerProvider ser) throws IOException {
        gen.writeTree(printable.print(new JsonMedia()).value());
    }
}