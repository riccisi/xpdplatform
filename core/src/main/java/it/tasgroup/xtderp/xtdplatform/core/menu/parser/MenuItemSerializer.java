package it.tasgroup.xtderp.xtdplatform.core.menu.parser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import it.tasgroup.xtderp.xtdplatform.core.localization.I18n;
import it.tasgroup.xtderp.xtdplatform.core.menu.model.MenuItem;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
public final class MenuItemSerializer extends JsonSerializer<MenuItem> {

    private final I18n i18n;

    @Override
    public void serialize(final MenuItem menuItem, final JsonGenerator jgen, final SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeStringField("id", menuItem.code());
        jgen.writeStringField("text", this.i18n.text(menuItem.code()));
        jgen.writeStringField("icon", "");
        jgen.writeBooleanField("folder", false);
        jgen.writeBooleanField("leaf", true);
        jgen.writeEndObject();
    }
}
