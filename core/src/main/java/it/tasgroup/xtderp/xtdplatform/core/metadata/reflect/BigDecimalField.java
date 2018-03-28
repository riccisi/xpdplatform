package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect;

import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.PrintableBigDecimal;
import it.tasgroup.xtderp.xtdplatform.core.metadata.Field;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@ToString
final class BigDecimalField extends AbstractField {

    BigDecimalField(final java.lang.reflect.Field field) {
        super(field);
    }

    @Override
    protected <T> Printable printableOf(final T entity) throws IllegalAccessException {
        final Object value = this.field.get(entity);
        return new PrintableBigDecimal(value != null ? BigDecimal.class.cast(value) : null);
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
            return BigDecimal.class == this.field.getType();
        }

        @Override
        public Field matched() {
            return new BigDecimalField(this.field);
        }
    }
}
