package it.tasgroup.xtderp.xtdplatform.infrastructure.menu.parser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.MenuItem;

import java.io.IOException;

public class MenuItemSerializer extends JsonSerializer<MenuItem> {

    @Override
    public void serialize(MenuItem menuItem, JsonGenerator jgen, SerializerProvider provider) throws IOException {

        jgen.writeStartObject();
        jgen.writeStringField("id", menuItem.code());
        jgen.writeStringField("icon", "");
        jgen.writeBooleanField("isFolder", false);
        jgen.writeBooleanField("isLeaf", true);
        jgen.writeEndObject();
    }
}
