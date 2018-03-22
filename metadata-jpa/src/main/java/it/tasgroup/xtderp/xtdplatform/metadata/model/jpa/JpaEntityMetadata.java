package it.tasgroup.xtderp.xtdplatform.metadata.model.jpa;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.metadata.model.Attribute;
import it.tasgroup.xtderp.xtdplatform.metadata.model.CachedModelMetadata;
import it.tasgroup.xtderp.xtdplatform.metadata.model.EntityMetadata;
import it.tasgroup.xtderp.xtdplatform.metadata.model.ModelMetadata;
import it.tasgroup.xtderp.xtdplatform.metadata.model.reflect.ClassModelMetadata;

import javax.persistence.EntityManager;
import java.util.Iterator;

public class JpaEntityMetadata<T> implements EntityMetadata<T> {

    private final EntityManager entityManager;

    private final Class<T> modelClass;

    private ModelMetadata fieldModelMetadata;

    public JpaEntityMetadata(EntityManager entityManager, Class<T> modelClass) {
        this.entityManager = entityManager;
        this.modelClass = modelClass;
        this.fieldModelMetadata = new CachedModelMetadata(new ClassModelMetadata<T>(this.modelClass));
    }

    @Override
    public String id() {
        return this.entityManager.getMetamodel().entity(this.modelClass).getName();
    }

    @Override
    public Iterator<Attribute> iterator() {
        return this.fieldModelMetadata.iterator();
    }

    @Override
    public <R> Rendered<R> print(Media<R> media) {
        throw new UnsupportedOperationException("#print()");
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

    @Override
    public void save(T entity) {
        this.entityManager.persist(entity);
    }

    @Override
    public void delete(T entity) {
        this.entityManager.remove(entity);
    }*/
}
