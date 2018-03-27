package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect;

import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.PrintableBoolean;
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
final class BooleanField extends AbstractField {

    BooleanField(java.lang.reflect.Field field) {
        super(field);
    }

    @Override
    protected <T> Printable printableOf(T entity) throws IllegalAccessException {
        Object value = this.field.get(entity);
        return new PrintableBoolean(value != null ? Boolean.class.cast(value) : null);
    }

    @Override
    protected String type() {
        return "boolean";
    }

    @RequiredArgsConstructor
    static final class Matcher implements FieldMatcher {

        @NonNull
        private final java.lang.reflect.Field field;

        @Override
        public boolean match() {
            return boolean.class == this.field.getType() || Boolean.class == this.field.getType();
        }

        @Override
        public Field matched() {
            return new BooleanField(this.field);
        }
    }
}