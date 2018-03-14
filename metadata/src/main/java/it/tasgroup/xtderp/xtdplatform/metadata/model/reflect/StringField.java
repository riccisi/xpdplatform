package it.tasgroup.xtderp.xtdplatform.metadata.model.reflect;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.RenderedObject;
import it.tasgroup.xtderp.xtdplatform.metadata.model.Field;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
final class StringField implements Field {

    private final java.lang.reflect.Field field;

    @Override
    public String name() {
        return this.field.getName();
    }

    @Override
    public <R, T> RenderedObject<R> renderValue(T entity, RenderedObject<R> rendered) {
        try {
            this.field.setAccessible(true);
            return rendered.with(this.field.getName(), (String)this.field.get(entity));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> Rendered<T> print(Media<T> media) {
        return media.asObject()
            .with("name", this.field.getName())
            .with("type", "string");
    }
}