package it.tasgroup.xtderp.xtdplatform.metadata.model.jpa;

import it.tasgroup.xtderp.xtdplatform.metadata.model.ModelConfigurer;
import it.tasgroup.xtderp.xtdplatform.metadata.model.ModelRegister;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

@Log
@RequiredArgsConstructor
public class JpaModelConfigurer implements ModelConfigurer {

    private final EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public void configure(ModelRegister modelRegister) {
        Set<EntityType<?>> entityTypes = this.entityManager.getMetamodel().getEntities();
        for (EntityType<?> entityType : entityTypes) {
            Class<?> entityClass = entityType.getJavaType();
            modelRegister.add(new JpaEntityMetadata(this.entityManager, entityClass));
            log.info(String.format("Entity %s successfully registered!", entityClass));
        }
    }
}