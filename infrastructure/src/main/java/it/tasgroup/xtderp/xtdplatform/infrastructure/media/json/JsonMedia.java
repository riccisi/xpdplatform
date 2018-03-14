package it.tasgroup.xtderp.xtdplatform.infrastructure.media.json;

import com.fasterxml.jackson.databind.JsonNode;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.RenderedObject;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * @todo #1 make a test for this class.
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
    public Rendered<JsonNode> as(byte value) {
        return new JsonByte(value);
    }

    @Override
    public Rendered<JsonNode> as(boolean value) {
        return new JsonBoolean(value);
    }

    @Override
    public Rendered<JsonNode> as(short value) {
        return new JsonFloat(value);
    }

    @Override
    public Rendered<JsonNode> as(int value) {
        return new JsonInt(value);
    }

    @Override
    public Rendered<JsonNode> as(long value) {
        return new JsonLong(value);
    }

    @Override
    public Rendered<JsonNode> as(float value) {
        return new JsonFloat(value);
    }

    @Override
    public Rendered<JsonNode> as(double value) {
        return new JsonDouble(value);
    }

    @Override
    public Rendered<JsonNode> as(String value) {
        return new JsonString(value);
    }

    @Override
    public Rendered<JsonNode> as(Date value) {
        return new JsonDate(value);
    }

    @Override
    public Rendered<JsonNode> as(BigDecimal value) {
        return new JsonBigDecimal(value);
    }

    @Override
    public Rendered<JsonNode> as(BigInteger value) {
        return new JsonBigInteger(value);
    }
}
