package it.tasgroup.xtderp.xtdplatform.core.metadata.jpa;

import it.tasgroup.xtderp.xtdplatform.core.metadata.MetadataConfigurer;
import it.tasgroup.xtderp.xtdplatform.core.metadata.MetadataRegister;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.Set;

@Log
@RequiredArgsConstructor
public class JpaMetadataConfigurer implements MetadataConfigurer {

    private final EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public void configure(MetadataRegister register) {
        Set<EntityType<?>> entityTypes = this.entityManager.getMetamodel().getEntities();
        for (EntityType<?> entityType : entityTypes) {
            Class<?> entityClass = entityType.getJavaType();
            register.add(new JpaEntityMetadata(this.entityManager, entityClass));
            log.info(String.format("Entity %s successfully registered!", entityClass));
        }
    }
}