package it.tasgroup.xtderp.xtdplatform.infrastructure.media.json;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import lombok.RequiredArgsConstructor;

/**
 * @todo make a tesr fot this class
 */
@RequiredArgsConstructor
public class JsonMedia implements Media<JsonRendered> {

    @Override
    public JsonRenderedObject object() {
        return new JsonRenderedObject();
    }

    @Override
    public JsonRenderedList list() {
        return new JsonRenderedList();
    }
}
