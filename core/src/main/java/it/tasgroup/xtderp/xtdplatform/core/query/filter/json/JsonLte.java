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
final class JsonLte extends JsonExpression {

    JsonLte(JsonNode node) {
        super(node);
    }

    @Override
    public void applyOn(Statement stmt) {
        stmt.lte(this.property(), Comparable.class.cast(this.value()));
    }

    @RequiredArgsConstructor
    static final class Matcher implements FilterMatcher {

        private final JsonNode node;

        @Override
        public boolean match() {
            JsonNode operator = this.node.path("operator");
            return !operator.isMissingNode() && Arrays.asList("lte", "<=").contains(operator.asText());
        }

        @Override
        public Filter matched() {
            return new JsonLte(this.node);
        }
    }
}
