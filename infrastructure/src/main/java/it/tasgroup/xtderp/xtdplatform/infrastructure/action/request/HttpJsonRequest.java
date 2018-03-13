package it.tasgroup.xtderp.xtdplatform.infrastructure.action.request;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;

import javax.servlet.http.HttpServletRequest;

/**
 * {@link Request} decorator that convert an {@link HttpServletRequest} into a {@link JsonNode} using Jackson library.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class HttpJsonRequest extends RequestDelegate<JsonNode> {

    public HttpJsonRequest(Request<HttpServletRequest> request) {
        super(
            new StreamToJsonRequest(
                new HttpToStreamRequest(request)
            )
        );
    }
}
