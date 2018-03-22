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
final class JsonGte extends JsonExpression {

    JsonGte(JsonNode node) {
        super(node);
    }

    @Override
    public void applyOn(Statement stmt) {
        stmt.gte(this.property(), Comparable.class.cast(this.value()));
    }

    @RequiredArgsConstructor
    static final class Matcher implements FilterMatcher {

        private final JsonNode node;

        @Override
        public boolean match() {
            JsonNode operator = this.node.path("operator");
            return !operator.isMissingNode() && Arrays.asList("gte", ">=").contains(operator.asText());
        }

        @Override
        public Filter matched() {
            return new JsonGte(this.node);
        }
    }
}
