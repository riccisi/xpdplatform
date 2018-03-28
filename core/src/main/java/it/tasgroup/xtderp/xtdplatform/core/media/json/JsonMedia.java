package it.tasgroup.xtderp.xtdplatform.core.media.json;

import com.fasterxml.jackson.databind.JsonNode;
import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.core.media.RenderedList;
import it.tasgroup.xtderp.xtdplatform.core.media.RenderedObject;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 */
@RequiredArgsConstructor
public final class JsonMedia implements Media<JsonNode> {

    @Override
    public RenderedObject<JsonNode> asObject() {
        return new JsonRenderedObject();
    }

    @Override
    public RenderedList<JsonNode> asList() {
        return new JsonRenderedList();
    }

    @Override
    public Rendered<JsonNode> as(final Byte value) {
        return new NullSafeJsonRendered(value, new JsonByte(value));
    }

    @Override
    public Rendered<JsonNode> as(final Boolean value) {
        return new NullSafeJsonRendered(value, new JsonBoolean(value));
    }

    @Override
    public Rendered<JsonNode> as(final Character value) {
        return new NullSafeJsonRendered(value, new JsonChar(value));
    }

    @Override
    public Rendered<JsonNode> as(final Short value) {
        return new NullSafeJsonRendered(value, new JsonShort(value));
    }

    @Override
    public Rendered<JsonNode> as(final Integer value) {
        return new NullSafeJsonRendered(value, new JsonInt(value));
    }

    @Override
    public Rendered<JsonNode> as(final Long value) {
        return new NullSafeJsonRendered(value, new JsonLong(value));
    }

    @Override
    public Rendered<JsonNode> as(final Float value) {
        return new NullSafeJsonRendered(value, new JsonFloat(value));
    }

    @Override
    public Rendered<JsonNode> as(final Double value) {
        return new NullSafeJsonRendered(value, new JsonDouble(value));
    }

    @Override
    public Rendered<JsonNode> as(final String value) {
        return new NullSafeJsonRendered(value, new JsonString(value));
    }

    @Override
    public Rendered<JsonNode> as(final Date value) {
        return new NullSafeJsonRendered(value, new JsonDate(value));
    }

    @Override
    public Rendered<JsonNode> as(final BigDecimal value) {
        return new NullSafeJsonRendered(value, new JsonBigDecimal(value));
    }

    @Override
    public Rendered<JsonNode> as(final BigInteger value) {
        return new JsonBigInteger(value);
    }

}
