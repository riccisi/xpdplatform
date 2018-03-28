package it.tasgroup.xtderp.xtdplatform.core.metadata.jpa;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.PrintableList;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.core.metadata.Attribute;
import it.tasgroup.xtderp.xtdplatform.core.metadata.Entity;
import it.tasgroup.xtderp.xtdplatform.core.metadata.EntityMetadata;
import it.tasgroup.xtderp.xtdplatform.core.metadata.ModelMetadata;
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

    @NonNull private final EntityManager manager;
    @NonNull private final Class<T> modelClass;
    private final ModelMetadata metadata;

    public JpaEntityMetadata(final EntityManager manager, final Class<T> modelClass) {
        this.manager = manager;
        this.modelClass = modelClass;
        this.metadata = new ClassModelMetadata<T>(this.modelClass);
    }

    @Override
    public String id() {
        return this.manager.getMetamodel().entity(this.modelClass).getName();
    }

    @Override
    public Iterator<Attribute> iterator() {
        return this.metadata.<Attribute>iterator();
    }

    @Override
    public <R> Rendered<R> print(final Media<R> media) {
        return media.asObject()
            .with("id", this.id())
            .with("type", "entity")
            .with("attributes", new PrintableList(this));
    }

    @Override
    public Entity newInstance() throws Exception {
        return new JpaEntity<T>(this.metadata.newInstance(), this, this.manager);
    }

   /* @Override
    public Serializable idOf(Object entity) {
        try {
            String idName = this.manager.getMetamodel().entity(this.modelClass).getId(this.modelClass).getName();
            Field idField = getFields(this.modelClass, withName(idName)).iterator().next();
            idField.setAccessible(true);
            return (Serializable) idField.get(entity);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Unable to get id value from entity %s", entity), e);
        }
    }

   */
}
