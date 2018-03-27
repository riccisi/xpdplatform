package it.tasgroup.xtderp.xtdplatform.core.media.csv;

import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.txt.TxtMedia;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.cactoos.list.Joined;
import org.cactoos.list.ListOf;
import org.cactoos.list.Mapped;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
@EqualsAndHashCode
final class CsvObject {

    private final List<String> headers;
    private final List<Printable> values;

    CsvObject() {
        this(new ListOf<>(), new ListOf<>());
    }

    public CsvObject add(String header, Printable value) {
        return new CsvObject(
            new Joined<>(this.headers, new ListOf<>(header)),
            new Joined<>(this.values, new ListOf<>(value))
        );
    }

    public String[] headers() {
        return headers.toArray(new String[headers.size()]);
    }

    public Iterable<Object> values() {
        TxtMedia media = new TxtMedia();
        return new Mapped<>(input -> input.print(media).value(), this.values);
    }
}