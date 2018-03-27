package it.tasgroup.xtderp.xtdplatform.core.util;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.text.ParseException;
import java.util.Date;

@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DefaultStringAsDate extends DefaultDateFormat implements Scalar<Date> {

    @NonNull
    private final String dateString;

    @Override
    public Date value() throws ParseException {
        return new StringAsDate(defaultFormat(), dateString).value();
    }
}