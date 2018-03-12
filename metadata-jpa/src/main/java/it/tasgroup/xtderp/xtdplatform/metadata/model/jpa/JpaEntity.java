package it.tasgroup.xtderp.xtdplatform.metadata.model.jpa;

import it.tasgroup.xtderp.xtdplatform.metadata.model.Attribute;
import it.tasgroup.xtderp.xtdplatform.metadata.model.CachedModel;
import it.tasgroup.xtderp.xtdplatform.metadata.model.Entity;
import it.tasgroup.xtderp.xtdplatform.metadata.model.ClassModel;
import it.tasgroup.xtderp.xtdplatform.metadata.model.Model;
import it.tasgroup.xtderp.xtdplatform.metadata.model.ProcessedModel;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Iterator;
import javax.persistence.EntityManager;

import static org.reflections.ReflectionUtils.getFields;
import static org.reflections.ReflectionUtils.withName;

public class JpaEntity<T> implements Entity<T> {

    private final EntityManager entityManager;

    private final Class<T> modelClass;

    private Model fieldModel;

    public JpaEntity(EntityManager entityManager, Class<T> modelClass) {
        this.entityManager = entityManager;
        this.modelClass = modelClass;
        this.fieldModel = new CachedModel(new ClassModel<T>(this.modelClass));
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
        Iterator<Attribute> fieldsIterator = this.fieldModel.iterator();
        return null;
    }

    @Override
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
    }
}
