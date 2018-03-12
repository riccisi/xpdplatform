package it.tasgroup.xtderp.xtdplatform.security;

import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.MenuConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityAutoconfig {

    @Bean
    public MenuConfigurer menuConfigurer() {
        return MenuConfigurer.EMPTY;
    }
}
