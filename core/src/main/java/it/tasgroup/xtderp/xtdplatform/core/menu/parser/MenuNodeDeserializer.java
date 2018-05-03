package it.tasgroup.xtderp.xtdplatform.core.menu.parser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import it.tasgroup.xtderp.xtdplatform.core.menu.DefaultMenuNode;
import it.tasgroup.xtderp.xtdplatform.core.menu.MenuNode;

import java.io.IOException;

/**
 * @todo #1 finish implementation or replace with parsing object
 */
public final class MenuNodeDeserializer extends JsonDeserializer<MenuNode> {

    @Override
    public MenuNode deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
        final ObjectCodec codec = p.getCodec();
        final JsonNode node = codec.readTree(p);
        final String code = node.get("id").asText();
        final MenuNode menuNode = new DefaultMenuNode(code);
        for (final JsonNode child : node.get("children")) {
            menuNode.add(codec.treeToValue(child, MenuNode.class));
        }
        return menuNode;
    }
}