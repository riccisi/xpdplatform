package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

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
public class PrintableDate implements Printable {

    private final Date value;

    @Override
    public <T> Rendered<T> print(Media<T> media) {
        return media.as(this.value);
    }
}
