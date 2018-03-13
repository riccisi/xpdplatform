package it.tasgroup.xtderp.xtdplatform.infrastructure.action.result;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Result;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * {@link Result} decorator that add content type information to the incoming {@link HttpServletResponse}
 * and delegate to the encapsulated {@link Result} accepting an {@link OutputStream}
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public class HttpContentResult implements Result<HttpServletResponse> {

    private static final String CONTENT_TYPE_FIELD = "Content-Type";
    private static final String DEFAULT_CONTENT_TYPE = "text/plain";

    private final Result<OutputStream> result;

    private final String contentType;

    public HttpContentResult(Result<OutputStream> result) {
        this(result, DEFAULT_CONTENT_TYPE);
    }

    @Override
    public void writeOn(HttpServletResponse response) throws Exception {
        response.setHeader(CONTENT_TYPE_FIELD, this.contentType);
        this.result.writeOn(response.getOutputStream());
    }
}