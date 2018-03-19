package it.tasgroup.xtderp.xtdplatform.metadata.model.reflect;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Printable;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.RenderedObject;
import it.tasgroup.xtderp.xtdplatform.metadata.model.Field;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
abstract class AbstractField implements Field {

    @NonNull
    protected final java.lang.reflect.Field field;

    @Override
    public final String name() {
        return this.field.getName();
    }

    @Override
    public final <R, T> RenderedObject<R> printValue(T entity, RenderedObject<R> rendered) {
        try {
            this.field.setAccessible(true);
            return rendered.with(this.field.getName(), this.printableOf(entity));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> Rendered<T> print(Media<T> media) {
        return media.asObject()
            .with("name", this.field.getName())
            .with("type", this.type());
    }

    protected abstract <T> Printable printableOf(T entity) throws IllegalAccessException;

    protected abstract String type();
}