package it.tasgroup.xtderp.xtdplatform.infrastructure.media.json;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.RenderedList;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.RenderedObject;
import lombok.RequiredArgsConstructor;

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
