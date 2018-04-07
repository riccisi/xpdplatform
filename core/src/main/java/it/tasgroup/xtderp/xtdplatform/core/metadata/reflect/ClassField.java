package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.core.media.RenderedObject;
import it.tasgroup.xtderp.xtdplatform.core.metadata.Field;
import it.tasgroup.xtderp.xtdplatform.core.metadata.reflect.type.Type;
import it.tasgroup.xtderp.xtdplatform.core.metadata.reflect.type.TypeOf;
import lombok.NonNull;

import java.text.ParseException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class ClassField implements Field {

    @NonNull private final java.lang.reflect.Field field;
    @NonNull private final Type<?> type;

    public ClassField(final java.lang.reflect.Field field) throws Exception {
        this.field = field;
        this.type = new TypeOf<>(field.getType());
    }

    @Override
    public String name() {
        return this.field.getName();
    }

    @Override
    public <R, T> RenderedObject<R> printValue(final T model, final RenderedObject<R> rendered) {
        try {
            this.field.setAccessible(true);
            final Object value = this.field.get(model);
            return rendered.with(this.field.getName(), this.type.printable(value));
        } catch (final IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> Rendered<T> print(final Media<T> media) {
        return media.asObject()
            .with("name", this.field.getName())
            .with("type", this.type.name());
    }

    @Override
    public Object parsedValue(final String value) throws ParseException {
        return this.type.value(value);
    }
}