package it.tasgroup.xtderp.xtdplatform.core.query.jpa;

import it.tasgroup.xtderp.xtdplatform.core.action.ActionConfigurer;
import it.tasgroup.xtderp.xtdplatform.core.localization.I18n;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@SuppressWarnings("DesignForExtension")
public class QueryJpaAutoConfig {

    @Bean
    public ActionConfigurer queryActionConfigurer(final EntityManager entityManager, final I18n i18n) {
        return new JpaQueryActionConfigurer(entityManager, i18n);
    }
}