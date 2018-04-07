package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect.type;

import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.PrintableByte;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class ByteType implements Type<Byte> {

    @Override
    public String name() {
        return "number";
    }

    @Override
    public Printable printable(final Object value) {
        return new PrintableByte(value != null ? Byte.class.cast(value) : null);
    }

    @Override
    public Byte value(final String text) {
        return Byte.parseByte(text);
    }

    @RequiredArgsConstructor
    static final class Matcher implements TypeMatcher<Byte> {

        @NonNull
        private final Class<?> type;

        @Override
        public boolean match() {
            return byte.class.equals(this.type) || Byte.class.equals(this.type);
        }

        @Override
        public Type<Byte> matched() {
            return new ByteType();
        }
    }
}