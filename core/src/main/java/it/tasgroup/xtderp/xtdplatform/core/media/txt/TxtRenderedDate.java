package it.tasgroup.xtderp.xtdplatform.core.media.txt;

import lombok.RequiredArgsConstructor;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class TxtRenderedDate extends TxtRendered {

    private final Date value;

    @Override
    public String value() {
        final DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
        return df.format(this.value);
    }
}