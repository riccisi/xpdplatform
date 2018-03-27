package it.tasgroup.xtderp.xtdplatform.core.media.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Printable;

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
        try {
            gen.writeTree(printable.print(new JsonMedia()).value());
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
}