package it.tasgroup.xtderp.xtdplatform.core.query.request;

import it.tasgroup.xtderp.xtdplatform.core.action.Request;
import it.tasgroup.xtderp.xtdplatform.core.action.request.JsonRequest;
import it.tasgroup.xtderp.xtdplatform.core.query.filter.json.JsonFilterOf;
import it.tasgroup.xtderp.xtdplatform.core.query.filter.json.JsonPaginatedFilter;
import it.tasgroup.xtderp.xtdplatform.core.query.filter.PaginatedFilter;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 *     This is a {@link Request} containing filtering instructions to dynamically build a paginated query.<br>
 *     It assume that the content of the body is in JSON format.
 * </p>
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class PaginatedFilterRequest implements Request {

    private final JsonRequest request;

    public PaginatedFilterRequest(Request request) {
        this.request = new JsonRequest(request);
    }

    @Override
    public InputStream body() throws IOException {
        return this.request.body();
    }

    public PaginatedFilter filter() throws Exception {
        return this.request.parse(node -> new JsonPaginatedFilter(node, new JsonFilterOf(node)));
    }
}