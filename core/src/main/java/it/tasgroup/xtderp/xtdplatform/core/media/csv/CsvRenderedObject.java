package it.tasgroup.xtderp.xtdplatform.core.media.csv;

import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.RenderedObject;
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
final class CsvRenderedObject implements RenderedObject<CsvObject>{

    private final CsvObject csvObject;

    CsvRenderedObject() {
        this(new CsvObject());
    }

    @Override
    public CsvRenderedObject with(String key, Printable val) {
        return new CsvRenderedObject(this.csvObject.add(key, val));
    }

    @Override
    public CsvObject value() {
        return this.csvObject;
    }

    @Override
    public void writeOn(final OutputStream stream) throws IOException {
        final OutputStreamWriter out = new OutputStreamWriter(stream);
        final CSVFormat format = CSVFormat.DEFAULT.withHeader(this.csvObject.headers());
        try (CSVPrinter printer = new CSVPrinter(out, format)) {
            printer.printRecord(this.csvObject.values());
        }
        stream.flush();
    }
}