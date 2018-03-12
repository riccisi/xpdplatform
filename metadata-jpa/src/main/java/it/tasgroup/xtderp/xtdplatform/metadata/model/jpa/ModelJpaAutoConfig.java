package it.tasgroup.xtderp.xtdplatform.metadata.model.jpa;

import it.tasgroup.xtderp.xtdplatform.metadata.model.ModelConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class ModelJpaAutoConfig {

    @Bean
    public ModelConfigurer modelConfigurer(EntityManager entityManager) {
        return new JpaModelConfigurer(entityManager);
    }
}
