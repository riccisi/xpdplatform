package it.tasgroup.xtderp.xtdplatform.infrastructure.media.json;

import com.fasterxml.jackson.databind.JsonNode;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.RenderedObject;
import lombok.RequiredArgsConstructor;

/**
 * @todo #1 make a test for this class.
 */
@RequiredArgsConstructor
public class JsonMedia implements Media<JsonNode> {

    @Override
    public JsonRenderedObject object() {
        return new JsonRenderedObject();
    }

    @Override
    public JsonRenderedList list() {
        return new JsonRenderedList();
    }
}
