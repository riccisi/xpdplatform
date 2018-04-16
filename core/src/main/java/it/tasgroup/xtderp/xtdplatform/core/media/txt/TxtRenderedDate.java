package it.tasgroup.xtderp.xtdplatform.core.media.txt;

import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class TxtRenderedDate extends TxtRendered {

    private final long value;

    TxtRenderedDate(final Date value) {
        this.value = value.getTime();
    }

    @Override
    public String value() {
        final DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, LocaleContextHolder.getLocale());
        return df.format(new Date(this.value));
    }
}