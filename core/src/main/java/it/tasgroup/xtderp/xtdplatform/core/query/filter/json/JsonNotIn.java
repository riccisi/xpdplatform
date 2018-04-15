package it.tasgroup.xtderp.xtdplatform.core.query.filter.json;

import com.fasterxml.jackson.databind.JsonNode;
import it.tasgroup.xtderp.xtdplatform.core.query.filter.Filter;
import it.tasgroup.xtderp.xtdplatform.core.query.filter.Statement;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
final class JsonNotIn extends JsonExpression {

    private JsonNotIn(final JsonNode node) {
        super(node);
    }

    @Override
    public void applyOn(final Statement stmt) {
        stmt.in(this.property(), Collection.class.cast(this.value()));
    }

    @RequiredArgsConstructor
    static final class Matcher implements FilterMatcher {

        private final JsonNode node;

        @Override
        public boolean match() {
            final JsonNode operator = this.node.path("operator");
            return !operator.isMissingNode() && "notin".equals(operator.asText());
        }

        @Override
        public Filter matched() {
            return new JsonNotIn(this.node);
        }
    }
}
