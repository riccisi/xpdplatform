package it.tasgroup.xtderp.xtdplatform.infrastructure.util;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DefaultStringAsDate extends DefaultDateFormat implements Scalar<Date> {

    @NonNull
    private final String dateString;

    @Override
    public Date value() {
        return new StringAsDate(defaultFormat(), dateString).value();
    }
}