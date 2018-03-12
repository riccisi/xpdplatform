package it.tasgroup.xtderp.xtdplatform.infrastructure.action.request;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

/**
 * {@link Request} decorator that gets a stream from an {@link HttpServletRequest}
 */
@RequiredArgsConstructor
public class HttpToStreamRequest implements Request<InputStream> {

    private final Request<HttpServletRequest> request;

    @Override
    public InputStream value() throws Exception {
        return this.request.value().getInputStream();
    }
}