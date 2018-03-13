package it.tasgroup.xtderp.xtdplatform.metadata.model.jpa;

import it.tasgroup.xtderp.xtdplatform.metadata.model.Attribute;
import it.tasgroup.xtderp.xtdplatform.metadata.model.CachedModelMetadata;
import it.tasgroup.xtderp.xtdplatform.metadata.model.EntityMetadata;
import it.tasgroup.xtderp.xtdplatform.metadata.model.ClassModelMetadata;
import it.tasgroup.xtderp.xtdplatform.metadata.model.ModelMetadata;
import it.tasgroup.xtderp.xtdplatform.metadata.model.ProcessedModel;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Iterator;
import javax.persistence.EntityManager;

import static org.reflections.ReflectionUtils.getFields;
import static org.reflections.ReflectionUtils.withName;

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
    public ProcessedModel process() {
        return null;
    }

    @Override
    public Iterator<Attribute> iterator() {
        Iterator<Attribute> fieldsIterator = this.fieldModelMetadata.iterator();
        return null;
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
