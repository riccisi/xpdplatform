package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.core.media.RenderedObject;
import it.tasgroup.xtderp.xtdplatform.core.metadata.Field;
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
    public final <R, T> RenderedObject<R> printValue(final T model, final RenderedObject<R> rendered) {
        try {
            this.field.setAccessible(true);
            return rendered.with(this.field.getName(), this.printableOf(model));
        } catch (final IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public final <T> Rendered<T> print(final Media<T> media) {
        return media.asObject()
            .with("name", this.field.getName())
            .with("type", this.type());
    }

    protected abstract <T> Printable printableOf(T entity) throws IllegalAccessException;

    protected abstract String type();
}