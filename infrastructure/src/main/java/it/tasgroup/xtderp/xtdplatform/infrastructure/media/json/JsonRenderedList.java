package it.tasgroup.xtderp.xtdplatform.infrastructure.media.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Printable;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.RenderedList;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class JsonRenderedList extends JsonRendered implements RenderedList<JsonNode> {

    private final List<JsonNode> list;

    JsonRenderedList() {
        this(new ArrayList<>());
    }

    @Override
    public JsonRenderedList with(Collection<Printable> printables) {
        return new JsonRenderedList(new ArrayList<JsonNode>(this.list){{
            for (Printable printable : printables) {
                this.add(((JsonRendered) printable.print(new JsonMedia())).value());
            }
        }});
    }

    @Override
    public JsonRenderedList with(Printable... v) {
        return this.with(Arrays.asList(v));
    }

    @Override
    public JsonNode value() {
        return new ArrayNode(JsonNodeFactory.instance, this.list);
    }
}