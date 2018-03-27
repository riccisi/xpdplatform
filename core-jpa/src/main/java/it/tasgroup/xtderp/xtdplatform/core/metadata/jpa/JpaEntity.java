package it.tasgroup.xtderp.xtdplatform.core.metadata.jpa;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.core.metadata.Entity;
import it.tasgroup.xtderp.xtdplatform.core.metadata.EntityMetadata;
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
public class JpaEntity<T> implements Entity {

    @NonNull private final ClassModel<T> classModel;
    @NonNull private final EntityMetadata metadata;
    @NonNull private final EntityManager entityManager;

    public JpaEntity(T classModel, EntityMetadata metadata, EntityManager entityManager) {
        this(new ClassModel<>(classModel, metadata), metadata, entityManager);
    }

    public JpaEntity(ClassModel<T> classModel, EntityMetadata metadata, EntityManager entityManager) {
        this.classModel = classModel;
        this.metadata = metadata;
        this.entityManager = entityManager;
    }

    @Override
    public void save() throws Exception {
        this.entityManager.persist(classModel.internal());
    }

    @Override
    public void delete() throws Exception {
        this.entityManager.remove(classModel.internal());
    }

    @Override
    @SuppressWarnings("unchecked")
    public <R> Rendered<R> print(Media<R> media) throws Exception {
        return this.classModel.print(media);
    }
}