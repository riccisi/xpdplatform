package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect.type;

import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.PrintableBoolean;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class BooleanType implements Type<Boolean> {

    @Override
    public String name() {
        return "string";
    }

    @Override
    public Printable printable(final Object value) {
        return new PrintableBoolean(value != null ? Boolean.class.cast(value) : null);
    }

    @Override
    public Boolean value(final String text) {
        return Boolean.valueOf(text);
    }

    @RequiredArgsConstructor
    static final class Matcher implements TypeMatcher<Boolean> {

        @NonNull
        private final Class<?> type;

        @Override
        public boolean match() {
            return boolean.class.equals(this.type) || Boolean.class.equals(this.type);
        }

        @Override
        public Type<Boolean> matched() {
            return new BooleanType();
        }
    }
}