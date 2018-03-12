package it.tasgroup.xtderp.xtdplatform.metadata.query;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class JsonPagedCondition implements PagedCondition {

    private static final String PAGE_FIELD = "page";
    private static final String LIMIT_FIELD = "limit";
    private static final int DEFAULT_PAGE = 1;

    private final JsonNode node;

    private final JsonFilters filters;

    public JsonPagedCondition(JsonNode node) {
        this.node = node;
        this.filters = new JsonFilters(node);
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
    public void apply(Statement statement) {
        this.filters.apply(statement);
    }
}
