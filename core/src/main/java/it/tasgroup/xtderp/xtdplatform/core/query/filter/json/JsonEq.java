package it.tasgroup.xtderp.xtdplatform.core.query.filter.json;

import com.fasterxml.jackson.databind.JsonNode;
import it.tasgroup.xtderp.xtdplatform.core.query.filter.Filter;
import it.tasgroup.xtderp.xtdplatform.core.query.filter.Statement;
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

    JsonEq(final JsonNode node) {
        super(node);
    }

    @Override
    public void applyOn(final Statement stmt) {
        stmt.eq(this.property(), this.value());
    }

    @RequiredArgsConstructor
    static final class Matcher implements FilterMatcher {

        private final JsonNode node;

        @Override
        public boolean match() {
            final JsonNode operator = this.node.path("operator");
            if (operator.isMissingNode()) {
                return this.node.has("exactMatch") && this.node.get("exactMatch").asBoolean();
            } else {
                return Arrays.asList("eq", "=", "==", "===").contains(operator.asText());
            }
        }

        @Override
        public Filter matched() {
            return new JsonEq(this.node);
        }
    }
}