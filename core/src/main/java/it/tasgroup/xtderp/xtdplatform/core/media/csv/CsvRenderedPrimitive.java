package it.tasgroup.xtderp.xtdplatform.core.media.csv;

import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class CsvRenderedPrimitive implements Rendered<Object> {

    private final Object value;

    @Override
    public Object value() {
        return this.value;
    }

    @Override
    public void writeOn(final OutputStream stream) throws IOException {
        final CSVFormat format = CSVFormat.DEFAULT.withHeader();
        try (final CSVPrinter printer = new CSVPrinter(new OutputStreamWriter(stream, Charset.forName("UTF-8")), format)) {
            printer.printRecord(this.value);
        }
    }
}