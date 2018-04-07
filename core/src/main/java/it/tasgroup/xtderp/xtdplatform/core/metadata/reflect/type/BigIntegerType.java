package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect.type;

import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.PrintableBigInteger;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class BigIntegerType implements Type<BigInteger> {

    @Override
    public String name() {
        return "number";
    }

    @Override
    public Printable printable(final Object value) {
        return new PrintableBigInteger(value != null ? BigInteger.class.cast(value) : null);
    }

    @Override
    public BigInteger value(final String text) {
        return new BigInteger(text);
    }

    @RequiredArgsConstructor
    static final class Matcher implements TypeMatcher<BigInteger> {

        @NonNull
        private final Class<?> type;

        @Override
        public boolean match() {
            return BigInteger.class.equals(this.type);
        }

        @Override
        public Type<BigInteger> matched() {
            return new BigIntegerType();
        }
    }
}