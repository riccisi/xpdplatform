package it.tasgroup.xtderp.xtdplatform.core.media.json;

import com.fasterxml.jackson.databind.JsonNode;
import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 */
@RequiredArgsConstructor
public final class JsonMedia implements Media<JsonNode> {

    @Override
    public JsonRenderedObject asObject() {
        return new JsonRenderedObject();
    }

    @Override
    public JsonRenderedList asList() {
        return new JsonRenderedList();
    }

    @Override
    public Rendered<JsonNode> as(Byte value) {
        return new NullSafeJsonRendered(value, new JsonByte(value));
    }

    @Override
    public Rendered<JsonNode> as(Boolean value) {
        return new NullSafeJsonRendered(value, new JsonBoolean(value));
    }

    @Override
    public Rendered<JsonNode> as(Character value) {
        return new NullSafeJsonRendered(value, new JsonChar(value));
    }

    @Override
    public Rendered<JsonNode> as(Short value) {
        return new NullSafeJsonRendered(value, new JsonShort(value));
    }

    @Override
    public Rendered<JsonNode> as(Integer value) {
        return new NullSafeJsonRendered(value, new JsonInt(value));
    }

    @Override
    public Rendered<JsonNode> as(Long value) {
        return new NullSafeJsonRendered(value, new JsonLong(value));
    }

    @Override
    public Rendered<JsonNode> as(Float value) {
        return new NullSafeJsonRendered(value, new JsonFloat(value));
    }

    @Override
    public Rendered<JsonNode> as(Double value) {
        return new NullSafeJsonRendered(value, new JsonDouble(value));
    }

    @Override
    public Rendered<JsonNode> as(String value) {
        return new NullSafeJsonRendered(value, new JsonString(value));
    }

    @Override
    public Rendered<JsonNode> as(Date value) {
        return new NullSafeJsonRendered(value, new JsonDate(value));
    }

    @Override
    public Rendered<JsonNode> as(BigDecimal value) {
        return new NullSafeJsonRendered(value, new JsonBigDecimal(value));
    }

    @Override
    public Rendered<JsonNode> as(BigInteger value) {
        return new JsonBigInteger(value);
    }

}
