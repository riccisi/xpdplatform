package it.tasgroup.xtderp.xtdplatform.core.media.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import lombok.extern.slf4j.Slf4j;

/**
 * Custom Jackson {@link JsonSerializer} to serialize a {@link Printable} using the {@link Media} API.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@Slf4j
public final class PrintableJsonSerializer extends JsonSerializer<Printable> {

    @Override
    public void serialize(final Printable printable, final JsonGenerator gen, final SerializerProvider ser) {
        try {
            gen.writeTree(printable.print(new JsonMedia()).value());
        } catch (final Exception e) {
            log.error("error serializing printable {}", printable);
            throw new RuntimeException(e);
        }
    }
}