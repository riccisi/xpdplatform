package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect.type;

import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.PrintableString;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class StringType implements Type<String> {

    @Override
    public String name() {
        return "string";
    }

    @Override
    public Printable printable(final Object value) {
        return new PrintableString(value != null ? String.class.cast(value) : null);
    }

    @Override
    public String value(final String text) {
        return text;
    }

    @RequiredArgsConstructor
    static final class Matcher implements TypeMatcher<String> {

        @NonNull
        private final Class<?> type;

        @Override
        public boolean match() {
            return String.class.equals(this.type);
        }

        @Override
        public Type<String> matched() {
            return new StringType();
        }
    }
}