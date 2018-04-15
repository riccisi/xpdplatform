package it.tasgroup.xtderp.xtdplatform.core.menu.parser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import it.tasgroup.xtderp.xtdplatform.core.action.Action;
import it.tasgroup.xtderp.xtdplatform.core.menu.model.DefaultMenuFolder;
import it.tasgroup.xtderp.xtdplatform.core.menu.model.DefaultMenuItem;
import it.tasgroup.xtderp.xtdplatform.core.menu.model.MenuNode;

import java.io.IOException;

public final class MenuNodeDeserializer extends JsonDeserializer<MenuNode> {

    @Override
    public MenuNode deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
        final ObjectCodec codec = p.getCodec();
        final JsonNode node = codec.readTree(p);
        final String code = node.get("id").asText();
        final boolean isFolder = node.get("isFolder").asBoolean();
        if(isFolder) {
            final DefaultMenuFolder folder = new DefaultMenuFolder(code);
            for (final JsonNode child : node.get("children")) {
                folder.add(codec.treeToValue(child, MenuNode.class));
            }
            return folder;
        } else {
            final Action action = node.hasNonNull("action") ? codec.treeToValue(node.get("action"), Action.class) : null;
            return new DefaultMenuItem(code, action);
        }
    }
}