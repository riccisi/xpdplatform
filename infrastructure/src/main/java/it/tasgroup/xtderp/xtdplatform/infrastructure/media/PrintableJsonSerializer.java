package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.json.JsonMedia;

import java.io.IOException;

public class PrintableJsonSerializer extends JsonSerializer<Printable> {

    @Override
    public void serialize(Printable printable, JsonGenerator gen, SerializerProvider ser) throws IOException {
        gen.writeTree(printable.print(new JsonMedia()).render());
    }
}
