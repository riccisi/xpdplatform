package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect;

import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.PrintableByte;
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
final class ByteField extends AbstractField {

    ByteField(java.lang.reflect.Field field) {
        super(field);
    }

    @Override
    protected <T> Printable printableOf(T entity) throws IllegalAccessException {
        Object value = this.field.get(entity);
        return new PrintableByte(value != null ? Byte.class.cast(value) : null);
    }

    @Override
    protected String type() {
        return "number";
    }

    @RequiredArgsConstructor
    static final class Matcher implements FieldMatcher {

        @NonNull  private final java.lang.reflect.Field field;

        @Override
        public boolean match() {
            return byte.class == this.field.getType() || Byte.class == this.field.getType();
        }

        @Override
        public Field matched() {
            return new ByteField(this.field);
        }
    }
}