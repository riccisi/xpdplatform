package it.tasgroup.xtderp.xtdplatform.infrastructure.action.result;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Output;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Result;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Printable;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.csv.CsvMedia;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class CsvResult implements Result {

    private static final String CSV_CONTENT_TYPE = "atext/csv;charset=UTF-8";

    private final Printable printable;

    @Override
    public void writeOn(Output output) throws IOException {
        output.ofType(CSV_CONTENT_TYPE);
        this.printable.print(new CsvMedia()).writeOn(output.stream());
    }
}