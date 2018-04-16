package it.tasgroup.xtderp.xtdplatform.core.media;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
@EqualsAndHashCode(of = "value", callSuper = false)
@ToString(of = "value")
public final class PrintableDate implements Printable {

    private final long value;

    public PrintableDate(final Date value) {
        this.value = value != null ? value.getTime() : -1L;
    }

    @Override
    public <T> Rendered<T> print(final Media<T> media) {
        return media.as(this.value > 0L ? new Date(this.value) : null);
    }
}
