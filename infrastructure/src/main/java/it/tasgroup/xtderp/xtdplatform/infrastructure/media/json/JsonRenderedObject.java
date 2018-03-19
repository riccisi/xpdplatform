package it.tasgroup.xtderp.xtdplatform.infrastructure.media.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.*;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.*;
import it.tasgroup.xtderp.xtdplatform.infrastructure.util.DefaultDateAsString;
import lombok.RequiredArgsConstructor;
import org.cactoos.Func;
import org.cactoos.func.FuncOf;
import org.cactoos.iterable.IterableOf;
import org.cactoos.list.Joined;
import org.cactoos.list.ListOf;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;

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
final class JsonRenderedObject extends JsonRendered implements RenderedObject<JsonNode> {

    private final List<MapEntry<String,Printable>> data;

    JsonRenderedObject() {
        this(new ListOf<>());
    }

    @Override
    public JsonRenderedObject with(String k, String v) {
        return this.with(k, new PrintableString(v));
    }

    @Override
    public JsonRenderedObject with(String k, byte v) {
        return this.with(k, new PrintableByte(v));
    }

    @Override
    public JsonRenderedObject with(String k, short v) {
        return this.with(k, new PrintableShort(v));
    }

    @Override
    public JsonRenderedObject with(String k, int v) {
        return this.with(k, new PrintableInt(v));
    }

    @Override
    public JsonRenderedObject with(String k, long v) {
        return this.with(k, new PrintableLong(v));
    }

    @Override
    public JsonRenderedObject with(String k, float v) {
        return this.with(k, new PrintableFloat(v));
    }

    @Override
    public JsonRenderedObject with(String k, double v) {
        return this.with(k, new PrintableDouble(v));
    }

    @Override
    public JsonRenderedObject with(String k, boolean v) {
        return this.with(k, new PrintableBoolean(v));
    }

    @Override
    public JsonRenderedObject with(String k, char v) {
        return this.with(k, new PrintableChar(v));
    }

    @Override
    public RenderedObject<JsonNode> with(String k, Number v) {
        throw new UnsupportedOperationException("#with()");
    }

    @Override
    public JsonRenderedObject with(String k, Date v) {
        return this.with(k, new PrintableDate(v));
    }

    @Override
    public JsonRenderedObject with(String k, BigDecimal v) {
        return this.with(k, new PrintableBigDecimal(v));
    }

    @Override
    public JsonRenderedObject with(String k, BigInteger v) {
        return this.with(k, new PrintableBigInteger(v));
    }

    @Override
    public JsonRenderedObject with(String k, List<Printable> v) {
        return this.with(k, new PrintableCollection(v));
    }

    @Override
    public RenderedObject<JsonNode> with(String k, String... v) {
        return this.with(k, new PrintableCollection(new ListOf<>(v), PrintableString::new));
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