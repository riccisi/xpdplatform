package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect.type;

import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.PrintableChar;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class CharType implements Type<Character> {

    @Override
    public String name() {
        return "string";
    }

    @Override
    public Printable printable(final Object value) {
        return new PrintableChar(value != null ? Character.class.cast(value) : null);
    }

    @Override
    public Character value(final String text) {
        return text.charAt(0);
    }

    @RequiredArgsConstructor
    static final class Matcher implements TypeMatcher<Character> {

        @NonNull
        private final Class<?> type;

        @Override
        public boolean match() {
            return char.class.equals(this.type) || Character.class.equals(this.type);
        }

        @Override
        public Type<Character> matched() {
            return new CharType();
        }
    }
}