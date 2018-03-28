package it.tasgroup.xtderp.xtdplatform.core.media.csv;

import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.RenderedList;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.cactoos.list.Joined;
import org.cactoos.list.ListOf;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
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
final class CsvRenderedList implements RenderedList<CsvObject> {

    private final List<Printable> printables;

    CsvRenderedList() {
        this(new ListOf<>());
    }

    @Override
    public CsvRenderedList with(final List<Printable> printables) {
        return new CsvRenderedList(new Joined<>(this.printables, printables));
    }

    @Override
    public CsvRenderedList with(final Printable... value) {
        return this.with(Arrays.asList(value));
    }

    @Override
    public CsvRenderedList with(Byte... value) {
        throw new UnsupportedOperationException("#with()");
    }

    @Override
    public CsvRenderedList with(Boolean... value) {
        throw new UnsupportedOperationException("#with()");
    }

    @Override
    public CsvRenderedList with(Short... value) {
        throw new UnsupportedOperationException("#with()");
    }

    @Override
    public CsvRenderedList with(Integer... value) {
        throw new UnsupportedOperationException("#with()");
    }

    @Override
    public CsvRenderedList with(Long... value) {
        throw new UnsupportedOperationException("#with()");
    }

    @Override
    public CsvRenderedList with(Float... value) {
        throw new UnsupportedOperationException("#with()");
    }

    @Override
    public CsvRenderedList with(Double... value) {
        throw new UnsupportedOperationException("#with()");
    }

    @Override
    public CsvRenderedList with(Character... value) {
        throw new UnsupportedOperationException("#with()");
    }

    @Override
    public CsvRenderedList with(String... value) {
        throw new UnsupportedOperationException("#with()");
    }

    @Override
    public CsvRenderedList with(Date... value) {
        throw new UnsupportedOperationException("#with()");
    }

    @Override
    public CsvRenderedList with(BigDecimal... value) {
        throw new UnsupportedOperationException("#with()");
    }

    @Override
    public CsvRenderedList with(BigInteger... value) {
        throw new UnsupportedOperationException("#with()");
    }

    @Override
    public CsvObject value() {
        throw new UnsupportedOperationException("#value()");
    }

    @Override
    public void writeOn(OutputStream stream) throws Exception {
        String[] headers = new String[0];
        List<Iterable<Object>> values = new ArrayList<>();
        CsvMedia media = new CsvMedia();
        for (Printable printable : this.printables) {
            CsvObject csvObject = printable.print(media).value();
            headers = csvObject.headers();
            values.add(csvObject.values());
        }

        OutputStreamWriter out = new OutputStreamWriter(stream);
        CSVFormat format = CSVFormat.DEFAULT.withHeader(headers);
        try (CSVPrinter printer = new CSVPrinter(out, format)) {
            for (Iterable<Object> record : values) {
                printer.printRecord(record);
            }
        }
    }
}
