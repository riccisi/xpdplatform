package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect.type;

import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.PrintableFloat;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class FloatType implements Type<Float> {

    @Override
    public String name() {
        return "number";
    }

    @Override
    public Printable printable(final Object value) {
        return new PrintableFloat(value != null ? Float.class.cast(value) : null);
    }

    @Override
    public Float value(final String text) {
        return Float.valueOf(text);
    }

    @RequiredArgsConstructor
    static final class Matcher implements TypeMatcher<Float> {

        @NonNull
        private final Class<?> type;

        @Override
        public boolean match() {
            return float.class.equals(this.type) || Float.class.equals(this.type);
        }

        @Override
        public Type<Float> matched() {
            return new FloatType();
        }
    }
}