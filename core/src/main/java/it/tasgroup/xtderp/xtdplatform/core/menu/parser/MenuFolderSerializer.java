package it.tasgroup.xtderp.xtdplatform.core.menu.parser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import it.tasgroup.xtderp.xtdplatform.core.localization.I18n;
import it.tasgroup.xtderp.xtdplatform.core.menu.model.MenuFolder;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
public final class MenuFolderSerializer extends JsonSerializer<MenuFolder> {

    private final I18n i18n;

    @Override
    public void serialize(MenuFolder folder, JsonGenerator jgen, SerializerProvider provider)
            throws IOException {

        jgen.writeStartObject();
        jgen.writeStringField("id", folder.code());
        jgen.writeStringField("text", this.i18n.text(folder.code()));
        jgen.writeStringField("icon", "");
        jgen.writeBooleanField("folder", true);
        jgen.writeBooleanField("leaf", false);
        jgen.writeObjectField("children", folder.iterator());
        jgen.writeEndObject();
    }
}
