package it.tasgroup.xtderp.xtdplatform.prototype;

import it.tasgroup.xtderp.xtdplatform.infrastructure.localization.MultipleBundleMessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class PrototypeConfig {

    @Autowired
    private MultipleBundleMessageSource messageSource;

    @PostConstruct
    public void init() {
        messageSource.addResource("prototype");
    }

/*
    @Bean
    public PrototypeMenuConfigurer menuConfigurer() {
        return new PrototypeMenuConfigurer();
    }
*/

}