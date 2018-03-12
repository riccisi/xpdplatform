package it.tasgroup.xtderp.xtdplatform.infrastructure.util;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@RequiredArgsConstructor
@EqualsAndHashCode
public class DateAsString implements Scalar<String> {

    @NonNull
    private final String format;

    @NonNull
    private final Date date;

    @Override
    public String value() {
        return new SimpleDateFormat(this.format).format(this.date);
    }
}