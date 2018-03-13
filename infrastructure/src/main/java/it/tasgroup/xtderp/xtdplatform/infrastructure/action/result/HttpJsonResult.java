package it.tasgroup.xtderp.xtdplatform.infrastructure.action.result;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Result;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Printable;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.json.JsonMedia;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 * {@link Result} that write a {@link Printable} object to an incoming {@link java.io.OutputStream} in JSON format.<br>
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class HttpJsonResult extends ResultDelegate<HttpServletResponse> {

    private static final String CONTENT_TYPE_JSON = "application/json;charset=UTF-8";

    public HttpJsonResult(Printable printable) {
        super(
            new HttpContentResult(
                new PrintableResult(printable, new JsonMedia()),
                CONTENT_TYPE_JSON
            )
        );
    }

    public HttpJsonResult(Collection<Printable> printable) {
        super(
            new HttpContentResult(
                new PrintableResult(printable, new JsonMedia()),
                CONTENT_TYPE_JSON
            )
        );
    }

    public HttpJsonResult(Iterable<Printable> printable) {
        super(
            new HttpContentResult(
                new PrintableResult(printable, new JsonMedia()),
                CONTENT_TYPE_JSON
            )
        );
    }
}