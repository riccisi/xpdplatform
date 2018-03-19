package it.tasgroup.xtderp.xtdplatform.infrastructure.media.csv;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.cactoos.list.ListOf;
import org.cactoos.list.Mapped;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

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

    public CsvRenderedObject() {
        this(new CsvObject());
    }

    @Override
    public CsvRenderedObject with(String k, String v) {
        return this.with(k, new PrintableString(v));
    }

    @Override
    public CsvRenderedObject with(String k, byte v) {
        return this.with(k, new PrintableByte(v));
    }

    @Override
    public CsvRenderedObject with(String k, short v) {
        return this.with(k, new PrintableShort(v));
    }

    @Override
    public CsvRenderedObject with(String k, int v) {
        return this.with(k, new PrintableInt(v));
    }

    @Override
    public CsvRenderedObject with(String k, long v) {
        return this.with(k, new PrintableLong(v));
    }

    @Override
    public CsvRenderedObject with(String k, float v) {
        return this.with(k, new PrintableFloat(v));
    }

    @Override
    public CsvRenderedObject with(String k, double v) {
        return this.with(k, new PrintableDouble(v));
    }

    @Override
    public CsvRenderedObject with(String k, boolean v) {
        return this.with(k, new PrintableBoolean(v));
    }

    @Override
    public CsvRenderedObject with(String k, char v) {
        return this.with(k, new PrintableChar(v));
    }

    @Override
    public CsvRenderedObject with(String k, Number v) {
        throw new UnsupportedOperationException("#with()");
    }

    @Override
    public CsvRenderedObject with(String k, Date v) {
        return this.with(k, new PrintableDate(v));
    }

    @Override
    public CsvRenderedObject with(String k, BigDecimal v) {
        return this.with(k, new PrintableBigDecimal(v));
    }

    @Override
    public CsvRenderedObject with(String k, BigInteger v) {
        return this.with(k, new PrintableBigInteger(v));
    }

    @Override
    public CsvRenderedObject with(String k, List<Printable> v) {
        return this.with(k, new PrintableCollection(v));
    }

    @Override
    public CsvRenderedObject with(String k, String... v) {
        return this.with(k, new PrintableCollection(new ListOf<>(v), PrintableString::new));
    }

    @Override
    public CsvRenderedObject with(String k, Printable v) {
        return new CsvRenderedObject(this.csvObject.add(k, v));
    }

    @Override
    public CsvObject value() {
        return this.csvObject;
    }

    @Override
    public void writeOn(OutputStream stream) throws IOException {
        OutputStreamWriter out = new OutputStreamWriter(stream);
        CSVFormat format = CSVFormat.DEFAULT.withHeader(this.csvObject.headers());
        try (CSVPrinter printer = new CSVPrinter(out, format)) {
            printer.printRecord(this.csvObject.values());
        }
        stream.flush();
    }
}
