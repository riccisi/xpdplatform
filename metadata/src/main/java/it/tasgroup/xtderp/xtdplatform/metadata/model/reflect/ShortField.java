package it.tasgroup.xtderp.xtdplatform.metadata.model.reflect;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.*;
import it.tasgroup.xtderp.xtdplatform.metadata.model.Field;
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
}