package it.tasgroup.xtderp.xtdplatform.core.query.filter.json;

import com.fasterxml.jackson.databind.JsonNode;
import it.tasgroup.xtderp.xtdplatform.core.util.DefaultStringAsDate;
import lombok.NonNull;
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

    @NonNull private final JsonNode node;

    public Object get() {
        Object value = null;
        if (!this.node.isNull() && !this.node.isMissingNode()) {
            value = this.parseValue(this.node);
        }
        return value;
    }

    private Object parseValue(final JsonNode node) {
        Object value = null;
        if (node.isArray()) {
            value = new ArrayList<>(
                    new Mapped<>(
                        this::parseValue,
                        node
                ));
        }
        else if (node.isTextual()) {
            final String text = node.asText();
            if ("true".equals(text)) {
                value = Boolean.TRUE;
            }
            else if ("false".equals(text)) {
                value = Boolean.FALSE;
            } else {
                try {
                    value = new DefaultStringAsDate(text).value();
                } catch (final ParseException ex) {
                    try {
                        value = ValueOf.asEnum(text);
                    } catch (final Exception exc) {
                        value = text;
                    }
                }
            }
        }
        else if (node.isShort()) {
            value = Short.valueOf(node.asText());
        }
        else if (node.isInt()) {
            value = node.asInt();
        }
        else if (node.isLong()) {
            value =  node.asLong();
        }
        else if (node.isDouble()) {
            value =  node.asDouble();
        }
        else if (node.isBoolean()) {
            value =  node.asBoolean();
        }
        else if (node.isBigInteger()) {
            value =  new BigInteger(node.asText());
        }
        else if (node.isBigDecimal()) {
            value =  new BigDecimal(node.asText());
        }
        return value;
    }

    @SuppressWarnings("unchecked")
    private static Enum asEnum(final String value) throws Exception {
        final String className = value.substring(0, value.lastIndexOf("."));
        final Class<Enum> enumClass = (Class<Enum>) Class.forName(className);
        final String enumConstant = value.substring(className.length() + 1, value.length());
        return Enum.valueOf(enumClass, enumConstant);
    }
}
