package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.core.media.RenderedObject;
import it.tasgroup.xtderp.xtdplatform.core.metadata.Attribute;
import it.tasgroup.xtderp.xtdplatform.core.metadata.Model;
import it.tasgroup.xtderp.xtdplatform.core.metadata.ModelMetadata;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * {@link Model} represented by a Java class.
 *
 * <p>The class is immutable and thread-safe.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class ClassModel<T> implements Model {

    @NonNull private final T model;
    @NonNull private final ModelMetadata metadata;

    @Override
    public <R> Rendered<R> print(Media<R> media) {
        RenderedObject<R> rendered = media.asObject();
        for (Attribute attribute : this.metadata) {
            rendered = attribute.printValue(this.model, rendered);
        }
        return rendered;
    }

    public T internal() {
        return this.model;
    }
}