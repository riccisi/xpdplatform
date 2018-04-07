package it.tasgroup.xtderp.xtdplatform.core.metadata.jpa;

import it.tasgroup.xtderp.xtdplatform.core.metadata.MetadataConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@SuppressWarnings("DesignForExtension")
public class JpaMetadataAutoConfig {

    @Bean
    public MetadataConfigurer modelConfigurer(final EntityManager entityManager) {
        return new JpaMetadataConfigurer(entityManager);
    }
}