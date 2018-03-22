package it.tasgroup.xtderp.xtdplatform.metadata.query.request;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.request.JsonRequest;
import it.tasgroup.xtderp.xtdplatform.metadata.query.filter.Filter;
import it.tasgroup.xtderp.xtdplatform.metadata.query.filter.json.JsonFilterOf;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 *     A {@link Request} containing filtering instructions to dynamically build a query.<br>
 *     It assume that the content of the body is in JSON format.
 * </p>
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class FilterRequest implements Request {

    private final JsonRequest request;

    public FilterRequest(Request request) {
        this.request = new JsonRequest(request);
    }

    @Override
    public InputStream body() throws IOException {
        return this.request.body();
    }

    public Filter filter() throws Exception {
        return this.request.parse(JsonFilterOf::new);
    }
}