package it.tasgroup.xtderp.xtdplatform.metadata.query;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static it.tasgroup.xtderp.xtdplatform.metadata.query.Operator.*;

@RequiredArgsConstructor
public class JsonFilter implements Condition {

    private SimpleDateFormat defaultDateFormat = new SimpleDateFormat("");

    private final JsonNode node;

    @Override
    public void apply(Statement stmt) {
        switch(operator()) {
            case eq: stmt.eq(property(), value());
            case noteq: stmt.notEq(property(), value());
            case like: stmt.like(property(), (String) value());
            case gt: stmt.gt(property(), (Comparable) value());
            case gte: stmt.gte(property(), (Comparable) value());
            case lt: stmt.lt(property(), (Comparable) value());
            case lte: stmt.lte(property(), (Comparable) value());
            case in: stmt.in(property(), (Collection) value());
            case notin: stmt.notIn(property(), (Collection) value());
            case isNull: stmt.isNull(property());
            case isNotNull: stmt.isNotNull(property());
        }
        throw new IllegalStateException();
    }

    private String property() {
        return node.get("property").asText();
    }

    private Operator operator() {
        if (node.has("operator") && !node.get("operator").asText().equalsIgnoreCase("null")) {
            return this.parseOperator(node.get("operator").asText());
        } else {
            boolean anyMatch = node.has("anyMatch") && node.get("anyMatch").asBoolean();
            boolean exactMatch = node.has("exactMatch") && node.get("exactMatch").asBoolean();
            return (!anyMatch && exactMatch) ? eq : like;
        }
    }

    private Object value() {
        JsonNode jsonValue = node.path("value");
        if (jsonValue.isNull() || jsonValue.isMissingNode()) {
            return null;
        } else {
            return parseValue(jsonValue);
        }
    }

    private Operator parseOperator(String operatorString) {
        switch (operatorString) {
            case "eq":
            case "=":
            case "==":
            case "===":
                return eq;
            case "!=":
            case "!==":
                return noteq;
            case "lt":
            case "<":
                return lt;
            case "<=":
                return lte;
            case "gt":
            case ">":
                return gt;
            case ">=":
                return gte;
            case "like":
                return like;
            case "in":
                return in;
            case "notin":
                return notin;
        }
        throw new IllegalArgumentException("Cannot parse operator value: " + operatorString);
    }

    private Object parseValue(JsonNode jsonValue) {
        if (jsonValue.isArray()) {
            List values = new ArrayList(jsonValue.size());
            Iterator<JsonNode> valueIterator = jsonValue.elements();
            while (valueIterator.hasNext()) {
                JsonNode nextValue = valueIterator.next();
                values.add(parseValue(nextValue));
            }
            return values;
        }

/*
        if (domainName != null) {
            Domain domain = this.domainPluginManager.getPlugin(domainName);
            return domain.lookup(jsonValue.asText());
        }
*/

        if (jsonValue.isTextual()) {
            String textual = jsonValue.asText();

            if ("true".equals(textual)) {
                return true;
            }
            if ("false".equals(textual)) {
                return false;
            }

            try {
                return this.defaultDateFormat.parse(textual);
            } catch (ParseException e) {
                try {
                    return this.asEnum(textual);
                } catch (Exception exc) {
                    return textual;
                }
            }
        }

        if (jsonValue.isShort()) {
            return jsonValue.asLong();
        }
        if (jsonValue.isInt()) {
            return jsonValue.asInt();
        }
        if (jsonValue.isLong()) {
            return jsonValue.asLong();
        }
        if (jsonValue.isDouble()) {
            return jsonValue.asDouble();
        }
        if (jsonValue.isBoolean()) {
            return jsonValue.asBoolean();
        }
        if (jsonValue.isBigInteger()) {
            return new BigInteger(jsonValue.asText());
        }
        if (jsonValue.isBigDecimal()) {
            return new BigDecimal(jsonValue.asText());
        }
        throw new IllegalArgumentException("Unparsable value: " + jsonValue);
    }

    private Enum asEnum(String textValue) throws Exception {
        String className = textValue.substring(0, textValue.lastIndexOf("."));
        Class<Enum> enumClass = (Class<Enum>) Class.forName(className);
        String enumConstant = textValue.substring(className.length() + 1, textValue.length());
        return Enum.valueOf(enumClass, enumConstant);
    }
}

