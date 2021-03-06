package it.tasgroup.xtderp.xtdplatform.core.query.filter.json;

import com.fasterxml.jackson.databind.JsonNode;
import it.tasgroup.xtderp.xtdplatform.core.query.filter.Filter;
import it.tasgroup.xtderp.xtdplatform.core.query.filter.PaginatedFilter;
import it.tasgroup.xtderp.xtdplatform.core.query.filter.Statement;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class JsonPaginatedFilter implements PaginatedFilter {

    private static final String PAGE_FIELD = "page";
    private static final String LIMIT_FIELD = "limit";
    private static final int DEFAULT_PAGE = 1;

    @NonNull private final JsonNode node;
    @NonNull private final Filter filters;

    public JsonPaginatedFilter(final JsonNode node) {
        this(node, node.has("filter") ? new JsonFilterOf(node.get("filter")) : Filter.EMPTY);
    }

    @Override
    public int page() {
        return this.node.has(PAGE_FIELD) ? this.node.get(PAGE_FIELD).asInt() : DEFAULT_PAGE;
    }

    @Override
    public int limit() {
        return this.node.has(LIMIT_FIELD) ? this.node.get(LIMIT_FIELD).asInt() : Integer.MAX_VALUE;
    }

    @Override
    public void applyOn(final Statement stmt) {
        this.filters.applyOn(stmt);
    }
}