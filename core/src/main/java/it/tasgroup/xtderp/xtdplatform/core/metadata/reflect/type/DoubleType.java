package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect.type;

import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.PrintableDouble;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class DoubleType implements Type<Double> {

    @Override
    public String name() {
        return "number";
    }

    @Override
    public Printable printable(final Object value) {
        return new PrintableDouble(value != null ? Double.class.cast(value) : null);
    }

    @Override
    public Double value(final String text) {
        return Double.valueOf(text);
    }

    @RequiredArgsConstructor
    static final class Matcher implements TypeMatcher<Double> {

        @NonNull
        private final Class<?> type;

        @Override
        public boolean match() {
            return double.class.equals(this.type) || Double.class.equals(this.type);
        }

        @Override
        public Type<Double> matched() {
            return new DoubleType();
        }
    }
}