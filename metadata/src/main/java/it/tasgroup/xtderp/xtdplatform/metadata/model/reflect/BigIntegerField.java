package it.tasgroup.xtderp.xtdplatform.metadata.model.reflect;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.*;
import it.tasgroup.xtderp.xtdplatform.metadata.model.Field;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@ToString
final class BigIntegerField extends AbstractField {

    BigIntegerField(java.lang.reflect.Field field) {
        super(field);
    }

    @Override
    protected <T> Printable printableOf(T entity) throws IllegalAccessException {
        Object value = this.field.get(entity);
        return new PrintableBigInteger(value != null ? BigInteger.class.cast(value) : null);
    }

    @Override
    protected String type() {
        return "number";
    }
}