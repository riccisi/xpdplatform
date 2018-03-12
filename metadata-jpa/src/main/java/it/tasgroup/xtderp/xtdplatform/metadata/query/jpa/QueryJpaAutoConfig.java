package it.tasgroup.xtderp.xtdplatform.metadata.query.jpa;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.ActionConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class QueryJpaAutoConfig {

    @Bean
    public ActionConfigurer queryActionConfigurer(EntityManager entityManager, ObjectMapper mapper) {
        return new JpaActionConfigurer(entityManager, mapper);
    }

}