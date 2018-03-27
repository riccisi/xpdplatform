package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect;

import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.PrintableShort;
import it.tasgroup.xtderp.xtdplatform.core.metadata.Field;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@ToString
public final class ShortField extends AbstractField {

    ShortField(java.lang.reflect.Field field) {
        super(field);
    }

    @Override
    protected <T> Printable printableOf(T entity) throws IllegalAccessException {
        Object value = this.field.get(entity);
        return new PrintableShort(value != null ? Short.class.cast(value) : null);
    }

    @Override
    protected String type() {
        return "number";
    }

    @RequiredArgsConstructor
    static final class Matcher implements FieldMatcher {

        @NonNull
        private final java.lang.reflect.Field field;

        @Override
        public boolean match() {
            return short.class == this.field.getType() || Short.class == this.field.getType();
        }

        @Override
        public Field matched() {
            return new ShortField(this.field);
        }
    }
}