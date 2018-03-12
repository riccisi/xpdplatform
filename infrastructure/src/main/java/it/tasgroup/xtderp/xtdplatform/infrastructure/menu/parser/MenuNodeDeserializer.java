package it.tasgroup.xtderp.xtdplatform.infrastructure.menu.parser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Action;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.DefaultMenuFolder;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.DefaultMenuItem;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.MenuNode;

import java.io.IOException;

public class MenuNodeDeserializer extends JsonDeserializer<MenuNode> {

    @Override
    public MenuNode deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec codec = p.getCodec();
        JsonNode node = codec.readTree(p);
        String code = node.get("id").asText();
        boolean isFolder = node.get("isFolder").asBoolean();
        if(isFolder) {
            DefaultMenuFolder folder = new DefaultMenuFolder(code);
            for (JsonNode jsonNode : node.get("children")) {
                folder.add(codec.treeToValue(jsonNode, MenuNode.class));
            }
            return folder;
        } else {
            Action action = node.hasNonNull("action") ? codec.treeToValue(node.get("action"), Action.class) : null;
            return new DefaultMenuItem(code, action);
        }
    }
}
