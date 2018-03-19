package it.tasgroup.xtderp.xtdplatform.infrastructure.action.result;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Printable;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.csv.CsvMedia;

import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class HttpCsvResult extends ResultDelegate<HttpServletResponse> {

    private static final String CONTENT_TYPE_CSV = "text/csv;charset=UTF-8";

    public HttpCsvResult(Printable printable) {
        super(
            new HttpContentResult(
                new PrintableResult(printable, new CsvMedia()),
                CONTENT_TYPE_CSV
            )
        );
    }
}
