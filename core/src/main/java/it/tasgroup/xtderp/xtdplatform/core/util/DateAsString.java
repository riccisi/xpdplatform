package it.tasgroup.xtderp.xtdplatform.core.util;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.springframework.context.i18n.LocaleContextHolder;

import java.text.SimpleDateFormat;
import java.util.Date;

@EqualsAndHashCode
@SuppressWarnings("WeakerAccess")
public final class DateAsString implements Scalar<String> {

    @NonNull private final String format;
    @NonNull private final long date;

    public DateAsString(final String format, final Date date) {
        this.format = format;
        this.date = date.getTime();
    }

    @Override
    public String value() {
        return new SimpleDateFormat(this.format, LocaleContextHolder.getLocale()).format(new Date(this.date));
    }
}