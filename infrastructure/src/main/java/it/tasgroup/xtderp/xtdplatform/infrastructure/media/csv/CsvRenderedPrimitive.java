package it.tasgroup.xtderp.xtdplatform.infrastructure.media.csv;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

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
    public void writeOn(OutputStream stream) throws IOException {
        CSVFormat format = CSVFormat.DEFAULT.withHeader();
        try (CSVPrinter printer = new CSVPrinter(new OutputStreamWriter(stream), format)) {
            printer.printRecord(value);
        }
    }
}