package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect;

import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.PrintableFloat;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@ToString
final class FloatField extends AbstractField {

    FloatField(Field field) {
        super(field);
    }

    @Override
    protected <T> Printable printableOf(T entity) throws IllegalAccessException {
        Object value = this.field.get(entity);
        return new PrintableFloat(value != null ? Float.class.cast(value) : null);
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
            return float.class == this.field.getType() || Float.class == this.field.getType();
        }

        @Override
        public it.tasgroup.xtderp.xtdplatform.core.metadata.Field matched() {
            return new FloatField(this.field);
        }
    }
}