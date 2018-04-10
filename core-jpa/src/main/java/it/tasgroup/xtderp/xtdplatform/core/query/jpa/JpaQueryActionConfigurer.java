package it.tasgroup.xtderp.xtdplatform.core.query.jpa;

import it.tasgroup.xtderp.xtdplatform.core.action.ActionConfigurer;
import it.tasgroup.xtderp.xtdplatform.core.action.ActionRegister;
import it.tasgroup.xtderp.xtdplatform.core.metadata.annotation.XtdExclude;
import it.tasgroup.xtderp.xtdplatform.core.query.action.CsvQueryAction;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.Set;

@Log
@RequiredArgsConstructor
public final class JpaQueryActionConfigurer implements ActionConfigurer {

    private final EntityManager entityManager;

    @Override
    @SuppressWarnings("MethodParameterOfConcreteClass")
    public void configure(final ActionRegister register) {
        final Set<EntityType<?>> types = this.entityManager.getMetamodel().getEntities();
        for (final EntityType<?> type : types) {
            final Class<?> cls = type.getJavaType();
            if(!cls.isAnnotationPresent(XtdExclude.class)) {
                register.add(new JsonJpaQueryAction(cls, this.entityManager));
                register.add(new CsvQueryAction(new JpaFullQuery<>(cls, this.entityManager)));
                log.info(String.format("Query actions for entity %s are successfully registered!", cls));
            }
        }
    }
}