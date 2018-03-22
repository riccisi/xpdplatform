package it.tasgroup.xtderp.xtdplatform.infrastructure.action.output;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Output;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class HttpOutput implements Output {

    private static final String CONTENT_TYPE_HEAD = "Content-Type";

    private final HttpServletResponse response;

    @Override
    public void ofType(String type) {
        this.response.setHeader(CONTENT_TYPE_HEAD, type);
    }

    @Override
    public OutputStream stream() throws IOException {
        return this.response.getOutputStream();
    }
}