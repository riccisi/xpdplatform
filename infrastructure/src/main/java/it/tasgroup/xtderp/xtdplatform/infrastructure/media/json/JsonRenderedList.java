package it.tasgroup.xtderp.xtdplatform.infrastructure.media.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Printable;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.RenderedList;
import lombok.RequiredArgsConstructor;
import org.cactoos.list.Joined;
import org.cactoos.list.ListOf;
import org.cactoos.list.Mapped;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
class JsonRenderedList extends JsonRendered implements RenderedList<JsonNode> {

    private final List<Printable> printables;

    JsonRenderedList() {
        this(new ListOf<>());
    }

    @Override
    public JsonRenderedList with(List<Printable> printables) {
        return new JsonRenderedList(new Joined<>(this.printables, printables));
    }

    @Override
    public JsonNode value() {
        JsonMedia media = new JsonMedia();
        return new ArrayNode(
            JsonNodeFactory.instance,
            new Mapped<>(printable -> printable.print(media).value(), this.printables)
        );
    }
}