package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect.type;

import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.PrintableBigDecimal;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class BigDecimalType implements Type<BigDecimal> {

    @Override
    public String name() {
        return "number";
    }

    @Override
    public Printable printable(final Object value) {
        return new PrintableBigDecimal(value != null ? BigDecimal.class.cast(value) : null);
    }

    @Override
    public BigDecimal value(final String text) {
        return new BigDecimal(text);
    }

    @RequiredArgsConstructor
    static final class Matcher implements TypeMatcher<BigDecimal> {

        @NonNull
        private final Class<?> type;

        @Override
        public boolean match() {
            return BigDecimal.class.equals(this.type);
        }

        @Override
        public Type<BigDecimal> matched() {
            return new BigDecimalType();
        }
    }
}