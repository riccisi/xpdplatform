package it.tasgroup.xtderp.xtdplatform.core.util;

import lombok.NonNull;

import java.util.Date;

public final class DefaultDateAsString extends DefaultDateFormat implements Scalar<String> {

    @NonNull
    private final long date;

    public DefaultDateAsString(final Date date) {
        this.date = date.getTime();
    }

    @Override
    public String value() {
        return new DateAsString(this.defaultFormat(), new Date(this.date)).value();
    }
}