package it.tasgroup.xtderp.xtdplatform.core.query.filter.json;

import com.fasterxml.jackson.databind.JsonNode;
import it.tasgroup.xtderp.xtdplatform.core.query.filter.Filter;
import it.tasgroup.xtderp.xtdplatform.core.query.filter.Statement;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cactoos.list.Mapped;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
final class JsonOr implements Filter {

    private static final String FILTERS = "filters";
    private static final String LOGIC_OPERATOR = "logicOperator";
    private static final String OR = "OR";

    @NonNull

    private final JsonNode node;
    @Override
    public void applyOn(Statement stmt) {
        stmt.or(new Mapped<>(JsonFilterOf::new, this.node.get("filters")));
    }

    @RequiredArgsConstructor
    static final class Matcher implements FilterMatcher {

        private final JsonNode node;

        @Override
        public boolean match() {
            return
                this.node.has(FILTERS) && this.node.has(LOGIC_OPERATOR) && OR.equalsIgnoreCase(this.node.get(LOGIC_OPERATOR).asText());
        }

        @Override
        public Filter matched() {
            return new JsonOr(this.node);
        }
    }
}