package it.tasgroup.xtderp.xtdplatform.core.menu.parser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import it.tasgroup.xtderp.xtdplatform.core.menu.model.MenuFolder;

import java.io.IOException;

public class MenuFolderSerializer extends JsonSerializer<MenuFolder> {

    @Override
    public void serialize(MenuFolder folder, JsonGenerator jgen, SerializerProvider provider)
            throws IOException {

        jgen.writeStartObject();
        jgen.writeStringField("id", folder.code());
        jgen.writeStringField("icon", "");
        jgen.writeBooleanField("isFolder", true);
        jgen.writeBooleanField("isLeaf", false);
        jgen.writeObjectField("children", folder.iterator());
        jgen.writeEndObject();
    }
}
