package it.tasgroup.xtderp.xtdplatform.core.query.filter.json;

import com.fasterxml.jackson.databind.JsonNode;
import it.tasgroup.xtderp.xtdplatform.core.query.filter.Statement;
import it.tasgroup.xtderp.xtdplatform.core.query.filter.Filter;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
final class JsonIn extends JsonExpression {

    JsonIn(JsonNode node) {
        super(node);
    }

    @Override
    public void applyOn(Statement stmt) {
        stmt.in(this.property(), Collection.class.cast(this.value()));
    }

    @RequiredArgsConstructor
    static final class Matcher implements FilterMatcher {

        private final JsonNode node;

        @Override
        public boolean match() {
            JsonNode operator = this.node.path("operator");
            return !operator.isMissingNode() && "in".equals(operator.asText());
        }

        @Override
        public Filter matched() {
            return new JsonIn(this.node);
        }
    }
}
