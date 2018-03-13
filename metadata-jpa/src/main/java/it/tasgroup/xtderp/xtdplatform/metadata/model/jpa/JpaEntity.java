package it.tasgroup.xtderp.xtdplatform.metadata.model.jpa;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Printable;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.RenderedObject;
import it.tasgroup.xtderp.xtdplatform.metadata.model.Attribute;
import it.tasgroup.xtderp.xtdplatform.metadata.model.Entity;
import it.tasgroup.xtderp.xtdplatform.metadata.model.EntityMetadata;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public class JpaEntity<T> implements Entity {

    private final T entity;
    private final EntityMetadata<T> metadata;

    @Override
    public void save() throws Exception {
        throw new UnsupportedOperationException("#save()");
    }

    @Override
    public void delete() throws Exception {
        throw new UnsupportedOperationException("#delete()");
    }

    @Override
    public Rendered print(Media media) {
        RenderedObject rendered = media.object();
        for (Attribute attribute : metadata) {
            rendered = rendered.with(attribute.name(), this.printableValue(attribute.name()));
        }
        return rendered;
    }

    private Printable printableValue(String attributeName) {
        return Printable.EMPTY;
    }
}