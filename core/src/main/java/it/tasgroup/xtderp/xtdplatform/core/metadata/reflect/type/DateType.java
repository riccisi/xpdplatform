package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect.type;

import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.PrintableDate;
import it.tasgroup.xtderp.xtdplatform.core.util.DefaultStringAsDate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.text.ParseException;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class DateType implements Type<Date> {

    @Override
    public String name() {
        return "date";
    }

    @Override
    public Printable printable(final Object value) {
        return new PrintableDate(value != null ? Date.class.cast(value) : null);
    }

    @Override
    public Date value(final String text) throws ParseException {
        return new DefaultStringAsDate(text).value();
    }

    @RequiredArgsConstructor
    static final class Matcher implements TypeMatcher<Date> {

        @NonNull
        private final Class<?> type;

        @Override
        public boolean match() {
            return Date.class.equals(this.type);
        }

        @Override
        public Type<Date> matched() {
            return new DateType();
        }
    }
}