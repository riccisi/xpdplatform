package it.tasgroup.xtderp.xtdplatform.metadata.query.filter.json;

import com.fasterxml.jackson.databind.JsonNode;
import it.tasgroup.xtderp.xtdplatform.metadata.query.filter.Statement;
import it.tasgroup.xtderp.xtdplatform.metadata.query.filter.Filter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
final class JsonEq extends JsonExpression {

    JsonEq(JsonNode node) {
        super(node);
    }

    @Override
    public void applyOn(Statement stmt) {
        stmt.eq(property(), value());
    }

    @RequiredArgsConstructor
    static final class Matcher implements FilterMatcher {

        private final JsonNode node;

        @Override
        public boolean match() {
            JsonNode operator = this.node.path("operator");
            if(!operator.isMissingNode()) {
                return Arrays.asList("eq", "=", "==", "===").contains(operator.asText());
            } else {
                return node.has("exactMatch") && node.get("exactMatch").asBoolean();
            }
        }

        @Override
        public Filter matched() {
            return new JsonEq(this.node);
        }
    }
}