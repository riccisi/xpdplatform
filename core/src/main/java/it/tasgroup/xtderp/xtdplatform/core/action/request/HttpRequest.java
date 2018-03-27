package it.tasgroup.xtderp.xtdplatform.core.action.request;

import it.tasgroup.xtderp.xtdplatform.core.action.Request;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class HttpRequest implements Request {

    private final HttpServletRequest request;

    @Override
    public InputStream body() throws IOException {
        return this.request.getInputStream();
    }
}
