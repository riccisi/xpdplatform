package it.tasgroup.xtderp.xtdplatform.infrastructure.media.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Printable;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.RenderedObject;
import lombok.RequiredArgsConstructor;
import org.cactoos.list.Joined;
import org.cactoos.list.ListOf;
import org.cactoos.map.MapEntry;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
final class JsonRenderedObject extends JsonRendered implements RenderedObject<JsonNode> {

    private final List<MapEntry<String,Printable>> data;

    JsonRenderedObject() {
        this(new ListOf<>());
    }

    @Override
    public JsonRenderedObject with(String k, Printable v) {
        return new JsonRenderedObject(new Joined<>(this.data, new ListOf<>(new MapEntry<>(k, v))));
    }

    @Override
    public JsonNode value() {
        JsonMedia media = new JsonMedia();
        Map<String,JsonNode> kids = new LinkedHashMap<>();
        for (MapEntry<String, Printable> entry : this.data) {
            kids.put(entry.getKey(), entry.getValue().print(media).value());
        }
        return new ObjectNode(JsonNodeFactory.instance, kids);
    }
}