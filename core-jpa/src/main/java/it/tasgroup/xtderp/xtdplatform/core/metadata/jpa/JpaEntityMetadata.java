package it.tasgroup.xtderp.xtdplatform.core.metadata.jpa;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.PrintableList;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.core.metadata.*;
import it.tasgroup.xtderp.xtdplatform.core.metadata.reflect.ClassModelMetadata;
import lombok.NonNull;

import javax.persistence.EntityManager;
import java.util.Iterator;

/**
 * {@link EntityMetadata} implementation that use JPA in order to describe an {@link Entity}.
 *
 * <p>The class is immutable and thread-safe.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 * @param <T> the JPA entity type.
 */
public final class JpaEntityMetadata<T> implements EntityMetadata {

    @NonNull private final EntityManager entityManager;
    @NonNull private final Class<T> modelClass;
    private ClassModelMetadata<T> modelMetadata;

    public JpaEntityMetadata(EntityManager entityManager, Class<T> modelClass) {
        this.entityManager = entityManager;
        this.modelClass = modelClass;
        this.modelMetadata = new ClassModelMetadata<T>(this.modelClass);
    }

    @Override
    public String id() {
        return this.entityManager.getMetamodel().entity(this.modelClass).getName();
    }

    @Override
    public Iterator<Attribute> iterator() {
        return this.modelMetadata.<Attribute>iterator();
    }

    @Override
    public <R> Rendered<R> print(Media<R> media) {
        return media.asObject()
            .with("id", this.id())
            .with("type", "entity")
            .with("attributes", new PrintableList(this));
    }

    @Override
    public Entity newInstance() throws Exception {
        return new JpaEntity<T>(this.modelMetadata.newInstance(), this, entityManager);
    }

   /* @Override
    public Serializable idOf(Object entity) {
        try {
            String idName = this.entityManager.getMetamodel().entity(this.modelClass).getId(this.modelClass).getName();
            Field idField = getFields(this.modelClass, withName(idName)).iterator().next();
            idField.setAccessible(true);
            return (Serializable) idField.get(entity);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Unable to get id value from entity %s", entity), e);
        }
    }

   */
}
