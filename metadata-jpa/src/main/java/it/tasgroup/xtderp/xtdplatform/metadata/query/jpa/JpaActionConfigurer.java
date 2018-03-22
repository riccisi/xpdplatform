package it.tasgroup.xtderp.xtdplatform.metadata.query.jpa;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.ActionConfigurer;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.ActionRegister;
import it.tasgroup.xtderp.xtdplatform.metadata.query.action.CsvQueryAction;
import it.tasgroup.xtderp.xtdplatform.metadata.query.action.JsonQueryAction;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.Set;

@RequiredArgsConstructor
@Log
public class JpaActionConfigurer implements ActionConfigurer {

    private final EntityManager entityManager;

    @Override
    public void configure(ActionRegister register) {
        Set<EntityType<?>> entityTypes = this.entityManager.getMetamodel().getEntities();
        for (EntityType<?> entityType : entityTypes) {
            Class<?> entityClass = entityType.getJavaType();
            register.add(new JsonQueryAction(new JpaPaginatedQuery<>(entityClass, entityManager)));
            register.add(new CsvQueryAction(new JpaFullQuery<>(entityClass, entityManager)));
            log.info(String.format("Query actions for entity %s succesfully registered!", entityClass));
        }
    }
}