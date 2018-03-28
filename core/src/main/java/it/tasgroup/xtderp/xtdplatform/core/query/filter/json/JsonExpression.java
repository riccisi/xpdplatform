package it.tasgroup.xtderp.xtdplatform.core.query.filter.json;

import com.fasterxml.jackson.databind.JsonNode;
import it.tasgroup.xtderp.xtdplatform.core.query.filter.Filter;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
abstract class JsonExpression implements Filter {

    private final JsonNode node;

    final String property() {
        return this.node.get("property").asText();
    }

    final Object value() {
        return new ValueOf(this.node.get("value")).get();
    }
}