package it.tasgroup.xtderp.xtdplatform.core.media.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.RenderedObject;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
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
@EqualsAndHashCode(callSuper = false)
@ToString
final class JsonRenderedObject extends JsonRendered implements RenderedObject<JsonNode> {

    private final List<MapEntry<String,Printable>> data;

    JsonRenderedObject() {
        this(new ListOf<>());
    }

    @Override
    public RenderedObject<JsonNode> with(final String key, final Printable val) {
        return new JsonRenderedObject(new Joined<>(this.data, new ListOf<>(new MapEntry<>(key, val))));
    }

    @Override
    public JsonNode value() throws Exception {
        final JsonMedia media = new JsonMedia();
        final Map<String,JsonNode> kids = new LinkedHashMap<>(0);
        for (final MapEntry<String, Printable> entry : this.data) {
            kids.put(entry.getKey(), entry.getValue().print(media).value());
        }
        return new ObjectNode(JsonNodeFactory.instance, kids);
    }
}