package it.tasgroup.xtderp.xtdplatform.infrastructure.media.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.*;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Printable;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.RenderedList;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.RenderedObject;
import it.tasgroup.xtderp.xtdplatform.infrastructure.util.DefaultDateAsString;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
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

    private final Map<String, JsonNode> data;

    JsonRenderedObject() {
        this(new LinkedHashMap<>());
    }

    @Override
    public JsonRenderedObject with(String k, String v) {
        return new JsonRenderedObject(new LinkedHashMap<String, JsonNode>(this.data) {{
            this.put(k, new TextNode(v));
        }});
    }

    @Override
    public JsonRenderedObject with(String k, byte v) {
        return new JsonRenderedObject(new LinkedHashMap<String, JsonNode>(this.data) {{
            this.put(k, new ShortNode(v));
        }});
    }

    @Override
    public JsonRenderedObject with(String k, short v) {
        return new JsonRenderedObject(new LinkedHashMap<String, JsonNode>(this.data) {{
            this.put(k, new ShortNode(v));
        }});
    }

    @Override
    public JsonRenderedObject with(String k, int v) {
        return new JsonRenderedObject(new LinkedHashMap<String, JsonNode>(this.data) {{
            this.put(k, new IntNode(v));
        }});
    }

    @Override
    public JsonRenderedObject with(String k, long v) {
        return new JsonRenderedObject(new LinkedHashMap<String, JsonNode>(this.data) {{
            this.put(k, new LongNode(v));
        }});
    }

    @Override
    public JsonRenderedObject with(String k, float v) {
        return new JsonRenderedObject(new LinkedHashMap<String, JsonNode>(this.data) {{
            this.put(k, new FloatNode(v));
        }});
    }

    @Override
    public JsonRenderedObject with(String k, double v) {
        return new JsonRenderedObject(new LinkedHashMap<String, JsonNode>(this.data) {{
            this.put(k, new DoubleNode(v));
        }});
    }

    @Override
    public JsonRenderedObject with(String k, boolean v) {
        return new JsonRenderedObject(new LinkedHashMap<String, JsonNode>(this.data) {{
            this.put(k, BooleanNode.valueOf(v));
        }});
    }

    @Override
    public JsonRenderedObject with(String k, char v) {
        return new JsonRenderedObject(new LinkedHashMap<String, JsonNode>(this.data) {{
            this.put(k, new TextNode("" + v));
        }});
    }

    @Override
    public JsonRenderedObject with(String k, Date v) {
        return new JsonRenderedObject(new LinkedHashMap<String, JsonNode>(this.data) {{
            this.put(k, new TextNode(new DefaultDateAsString(v).value()));
        }});
    }

    @Override
    public JsonRenderedObject with(String k, BigDecimal v) {
        return new JsonRenderedObject(new LinkedHashMap<String, JsonNode>(this.data) {{
            this.put(k, new DecimalNode(v));
        }});
    }

    @Override
    public JsonRenderedObject with(String k, BigInteger v) {
        return new JsonRenderedObject(new LinkedHashMap<String, JsonNode>(this.data) {{
            this.put(k, new BigIntegerNode(v));
        }});
    }

    @Override
    public JsonRenderedObject with(String k, Collection<Printable> v) {
        return new JsonRenderedObject(new LinkedHashMap<String, JsonNode>(this.data) {{
            this.put(k, new JsonRenderedList().with(v).value());
        }});
    }

    @Override
    public RenderedObject<JsonNode> with(String k, String... v) {
        return new JsonRenderedObject(new LinkedHashMap<String, JsonNode>(this.data) {{
            this.put(k, new JsonRenderedList().with(v).value());
        }});
    }

    @Override
    public JsonRenderedObject with(String k, Printable v) {
        return new JsonRenderedObject(new LinkedHashMap<String, JsonNode>(this.data) {{
            this.put(k, ((v.print(new JsonMedia())).value()));
        }});
    }

    @Override
    public JsonNode value() {
        return new ObjectNode(JsonNodeFactory.instance, this.data);
    }
}
