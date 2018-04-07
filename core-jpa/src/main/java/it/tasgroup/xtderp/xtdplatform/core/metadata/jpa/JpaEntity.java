package it.tasgroup.xtderp.xtdplatform.core.metadata.jpa;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.core.metadata.Entity;
import it.tasgroup.xtderp.xtdplatform.core.metadata.EntityMetadata;
import it.tasgroup.xtderp.xtdplatform.core.metadata.Model;
import it.tasgroup.xtderp.xtdplatform.core.metadata.reflect.ClassModel;
import lombok.NonNull;

import javax.persistence.EntityManager;

/**
 * Created with IntelliJ IDEA.
 *
 * <p>The class is immutable and thread-safe.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class JpaEntity<T> implements Entity<T> {

    @NonNull private final Model<T> model;
    @NonNull private final EntityMetadata<T> metadata;
    @NonNull private final EntityManager manager;

    public JpaEntity(final T model, final EntityMetadata<T> metadata, final EntityManager manager) {
        this(new ClassModel<>(model, metadata), metadata, manager);
    }

    public JpaEntity(final Model<T> model, final EntityMetadata<T> metadata, final EntityManager manager) {
        this.model = model;
        this.metadata = metadata;
        this.manager = manager;
    }

    @Override
    public void save() {
        this.manager.persist(this.model.value());
    }

    @Override
    public void delete() {
        this.manager.remove(this.model.value());
    }

    @Override
    @SuppressWarnings("unchecked")
    public <R> Rendered<R> print(final Media<R> media) throws Exception {
        return this.model.print(media);
    }

    @Override
    public T value() {
        return this.model.value();
    }
}