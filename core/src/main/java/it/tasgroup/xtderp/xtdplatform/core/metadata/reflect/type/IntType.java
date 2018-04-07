package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect.type;

import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.PrintableInt;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class IntType implements Type<Integer> {

    @Override
    public String name() {
        return "number";
    }

    @Override
    public Printable printable(final Object value) {
        return new PrintableInt(value != null ? Integer.class.cast(value) : null);
    }

    @Override
    public Integer value(final String text) {
        return Integer.parseInt(text);
    }

    @RequiredArgsConstructor
    static final class Matcher implements TypeMatcher<Integer> {

        @NonNull
        private final Class<?> type;

        @Override
        public boolean match() {
            return int.class.equals(this.type) || Integer.class.equals(this.type);
        }

        @Override
        public Type<Integer> matched() {
            return new IntType();
        }
    }
}