package it.tasgroup.xtderp.xtdplatform.core.util;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
public class DefaultDateAsString extends DefaultDateFormat implements Scalar<String> {

    @NonNull
    private final Date date;

    @Override
    public String value() {
        return new DateAsString(this.defaultFormat(), this.date).value();
    }
}