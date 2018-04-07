package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect.type;

import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.PrintableShort;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class ShortType implements Type<Short> {

    @Override
    public String name() {
        return "number";
    }

    @Override
    public Printable printable(final Object value) {
        return new PrintableShort(value != null ? Short.class.cast(value) : null);
    }

    @Override
    public Short value(final String text) {
        return Short.valueOf(text);
    }

    @RequiredArgsConstructor
    static final class Matcher implements TypeMatcher<Short> {

        @NonNull
        private final Class<?> type;

        @Override
        public boolean match() {
            return short.class.equals(this.type) || Short.class.equals(this.type);
        }

        @Override
        public Type<Short> matched() {
            return new ShortType();
        }
    }
}