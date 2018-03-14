package it.tasgroup.xtderp.xtdplatform.infrastructure.media.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.*;
import lombok.RequiredArgsConstructor;
import org.cactoos.collection.CollectionOf;
import org.cactoos.list.Mapped;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
class JsonRenderedList extends JsonRendered implements RenderedList<JsonNode> {

    private final List<JsonNode> list;

    JsonRenderedList() {
        this(new ArrayList<>());
    }

    @Override
    public JsonRenderedList with(Collection<Printable> printables) {
        JsonMedia media = new JsonMedia();
        return new JsonRenderedList(new ArrayList<JsonNode>(this.list){{
            for (Printable printable : printables) {
                this.add(printable.print(media).value());
            }
        }});
    }

    @Override
    public JsonRenderedList with(String... value) {
        return with(new Mapped<>(PrintableString::new, new CollectionOf<>(value)));
    }

    @Override
    public RenderedList<JsonNode> with(Integer... value) {
        return with(new Mapped<>(PrintableInt::new, new CollectionOf<>(value)));
    }

    @Override
    public RenderedList<JsonNode> with(Long... value) {
        return with(new Mapped<>(PrintableLong::new, new CollectionOf<>(value)));
    }

    @Override
    public RenderedList<JsonNode> with(Float... value) {
        return with(new Mapped<>(PrintableFloat::new, new CollectionOf<>(value)));
    }

    @Override
    public RenderedList<JsonNode> with(Double... value) {
        return with(new Mapped<>(PrintableDouble::new, new CollectionOf<>(value)));
    }

    @Override
    public RenderedList<JsonNode> with(Character... value) {
        return with(new Mapped<>(PrintableChar::new, new CollectionOf<>(value)));
    }

    @Override
    public RenderedList<JsonNode> with(Date... value) {
        return with(new Mapped<>(PrintableDate::new, new CollectionOf<>(value)));
    }

    @Override
    public RenderedList<JsonNode> with(BigDecimal... value) {
        return with(new Mapped<>(PrintableBigDecimal::new, new CollectionOf<>(value)));
    }

    @Override
    public RenderedList<JsonNode> with(BigInteger... value) {
        return with(new Mapped<>(PrintableBigInteger::new, new CollectionOf<>(value)));
    }

    @Override
    public JsonRenderedList with(Printable... v) {
        return this.with(Arrays.asList(v));
    }

    @Override
    public RenderedList<JsonNode> with(Byte... value) {
        return with(new Mapped<>(PrintableByte::new, new CollectionOf<>(value)));
    }

    @Override
    public RenderedList<JsonNode> with(Boolean... value) {
        return with(new Mapped<>(PrintableBoolean::new, new CollectionOf<>(value)));
    }

    @Override
    public RenderedList<JsonNode> with(Short... value) {
        return with(new Mapped<>(PrintableShort::new, new CollectionOf<>(value)));
    }

    @Override
    public JsonNode value() {
        return new ArrayNode(JsonNodeFactory.instance, this.list);
    }
}