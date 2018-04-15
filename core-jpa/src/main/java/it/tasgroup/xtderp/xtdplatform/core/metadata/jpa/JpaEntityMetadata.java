package it.tasgroup.xtderp.xtdplatform.core.metadata.jpa;

import it.tasgroup.xtderp.xtdplatform.core.action.Request;
import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.PrintableList;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.core.metadata.*;
import it.tasgroup.xtderp.xtdplatform.core.metadata.reflect.ClassModelMetadata;
import lombok.NonNull;
import org.cactoos.iterable.Filtered;
import org.cactoos.iterable.ItemAt;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.Iterator;

/**
 * {@link EntityMetadata} implementation that use JPA in order to describe/manage an {@link Entity}.
 *
 * <p>The class is immutable and thread-safe.
 *
 * @param <T> the JPA entity type.
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
public final class JpaEntityMetadata<T> implements EntityMetadata<T> {

    @NonNull private final EntityManager manager;
    @NonNull private final Class<T> modelClass;
    @NonNull private final ModelMetadata<T> metadata;
    @NonNull private final Field id;

    public JpaEntityMetadata(final EntityManager manager, final Class<T> modelClass) {
        this.manager = manager;
        this.modelClass = modelClass;
        this.metadata = new ClassModelMetadata<T>(this.modelClass);
        this.id = this.idField();
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
    public Entity<T> newInstance() throws Exception {
        return new JpaEntity<T>(this.metadata.newInstance(), this, this.manager);
    }

    @Override
    public Entity<T> read(final Request request) throws Exception {
        final Object value = this.id.parsedValue(request.param("id"));
        return new JpaEntity<T>(this.manager.find(this.modelClass, value), this, this.manager);
    }

    private Field idField() {
        try {
            final EntityType<T> type = this.manager.getMetamodel().entity(this.modelClass);
            final String name = type.getId(type.getIdType().getJavaType()).getName();
            return new ItemAt<>(
                0,
                new Filtered<>(
                    input -> input.name().equals(name),
                    new Fields(this.metadata)
                )
            ).value();
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }

}