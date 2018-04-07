package it.tasgroup.xtderp.xtdplatform.core.query.jpa;

import it.tasgroup.xtderp.xtdplatform.core.action.ActionConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@SuppressWarnings("DesignForExtension")
public class QueryJpaAutoConfig {

    @Bean
    public ActionConfigurer queryActionConfigurer(final EntityManager entityManager) {
        return new JpaQueryActionConfigurer(entityManager);
    }
}