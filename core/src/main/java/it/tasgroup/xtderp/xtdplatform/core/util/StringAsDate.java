package it.tasgroup.xtderp.xtdplatform.core.util;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Scalar asObject that "represent" the date value of a String
 */
@RequiredArgsConstructor
@EqualsAndHashCode
public class StringAsDate implements Scalar<Date> {

    @NonNull
    private final String format;

    @NonNull
    private final String dateString;

    @Override
    public Date value() throws ParseException {
        return new SimpleDateFormat(format).parse(this.dateString);
    }
}