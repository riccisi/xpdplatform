package it.tasgroup.xtderp.xtdplatform.metadata.query.filter.json;

import com.fasterxml.jackson.databind.JsonNode;
import it.tasgroup.xtderp.xtdplatform.infrastructure.util.DefaultStringAsDate;
import lombok.RequiredArgsConstructor;
import org.cactoos.list.Mapped;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class ValueOf {

    private final JsonNode node;

    public Object get() {
        if (node.isNull() || node.isMissingNode()) {
            return null;
        } else {
            return parseValue(node);
        }
    }

    private Object parseValue(JsonNode node) {
        if (node.isArray()) {
            return
                new ArrayList<>(
                    new Mapped<>(
                        this::parseValue,
                        node
                ));
        }
        if (node.isTextual()) {
            String textual = node.asText();
            if ("true".equals(textual)) {
                return true;
            }
            if ("false".equals(textual)) {
                return false;
            }
            try {
                return new DefaultStringAsDate(textual).value();
            } catch (ParseException e) {
                try {
                    return this.asEnum(textual);
                } catch (Exception exc) {
                    return textual;
                }
            }
        }
        if (node.isShort()) {
            return Short.valueOf(node.asText());
        }
        if (node.isInt()) {
            return node.asInt();
        }
        if (node.isLong()) {
            return node.asLong();
        }
        if (node.isDouble()) {
            return node.asDouble();
        }
        if (node.isBoolean()) {
            return node.asBoolean();
        }
        if (node.isBigInteger()) {
            return new BigInteger(node.asText());
        }
        if (node.isBigDecimal()) {
            return new BigDecimal(node.asText());
        }
        throw new IllegalArgumentException("Unparsable value: " + node);
    }

    @SuppressWarnings("unchecked")
    private Enum asEnum(String textValue) throws Exception {
        String className = textValue.substring(0, textValue.lastIndexOf("."));
        Class<Enum> enumClass = (Class<Enum>) Class.forName(className);
        String enumConstant = textValue.substring(className.length() + 1, textValue.length());
        return Enum.valueOf(enumClass, enumConstant);
    }
}
