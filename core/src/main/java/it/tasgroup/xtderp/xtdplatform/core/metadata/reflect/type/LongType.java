package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect.type;

import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.PrintableLong;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class LongType implements Type<Long> {

    @Override
    public String name() {
        return "number";
    }

    @Override
    public Printable printable(final Object value) {
        return new PrintableLong(value != null ? Long.class.cast(value) : null);
    }

    @Override
    public Long value(final String text) {
        return Long.parseLong(text);
    }

    @RequiredArgsConstructor
    static final class Matcher implements TypeMatcher<Long> {

        @NonNull
        private final Class<?> type;

        @Override
        public boolean match() {
            return long.class.equals(this.type) || Long.class.equals(this.type);
        }

        @Override
        public Type<Long> matched() {
            return new LongType();
        }
    }
}