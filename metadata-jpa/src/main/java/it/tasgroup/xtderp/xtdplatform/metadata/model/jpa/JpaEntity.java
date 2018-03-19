package it.tasgroup.xtderp.xtdplatform.metadata.model.jpa;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.RenderedObject;
import it.tasgroup.xtderp.xtdplatform.metadata.model.Attribute;
import it.tasgroup.xtderp.xtdplatform.metadata.model.Entity;
import it.tasgroup.xtderp.xtdplatform.metadata.model.EntityMetadata;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public class JpaEntity<T> implements Entity {

    @NonNull private final T entity;
    @NonNull private final EntityMetadata<T> metadata;
    @NonNull private final EntityManager entityManager;

    @Override
    public void save() throws Exception {
        this.entityManager.persist(entity);
    }

    @Override
    public void delete() throws Exception {
        this.entityManager.remove(entity);
    }

    @Override
    public <R> Rendered<R> print(Media<R> media) {
        RenderedObject<R> rendered = media.asObject();
        for (Attribute attribute : metadata) {
            rendered = attribute.printValue(entity, rendered);
        }
        return rendered;
    }
}