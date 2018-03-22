package it.tasgroup.xtderp.xtdplatform.metadata.query.filter.json;

import com.fasterxml.jackson.databind.JsonNode;
import it.tasgroup.xtderp.xtdplatform.metadata.query.filter.Statement;
import it.tasgroup.xtderp.xtdplatform.metadata.query.filter.Filter;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
final class JsonLike extends JsonExpression {

    JsonLike(JsonNode node) {
        super(node);
    }

    @Override
    public void applyOn(Statement stmt) {
        stmt.like(this.property(), this.value().toString());
    }

    @RequiredArgsConstructor
    static final class Matcher implements FilterMatcher {

        private final JsonNode node;

        @Override
        public boolean match() {
            JsonNode operator = this.node.path("operator");
            if(!operator.isMissingNode()) {
                return "like".equals(operator.asText());
            } else {
                return node.has("anyMatch") && node.get("anyMatch").asBoolean();
            }
        }

        @Override
        public Filter matched() {
            return new JsonLike(this.node);
        }
    }
}
