package it.tasgroup.xtderp.xtdplatform.metadata.query.jpa;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.ActionConfigurer;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.ActionRegister;
import it.tasgroup.xtderp.xtdplatform.metadata.query.JsonQueryAction;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.Set;

@RequiredArgsConstructor
@Log
public class JpaActionConfigurer implements ActionConfigurer {

    private final EntityManager entityManager;

    private final ObjectMapper mapper;

    @Override
    public void configure(ActionRegister register) {
        Set<EntityType<?>> entityTypes = this.entityManager.getMetamodel().getEntities();
        for (EntityType<?> entityType : entityTypes) {
            Class<?> entityClass = entityType.getJavaType();
            register.add(new JsonQueryAction<>(new JpaPagedQueryAction<>(entityClass, entityManager), mapper));
            log.info(String.format("Query for entity %s succesfully registered!", entityClass));
        }
    }
}