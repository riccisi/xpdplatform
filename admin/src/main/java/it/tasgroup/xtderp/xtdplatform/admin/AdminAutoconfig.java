package it.tasgroup.xtderp.xtdplatform.admin;

import it.tasgroup.xtderp.xtdplatform.core.menu.model.MenuConfigurer;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = "it.tasgroup.xtderp.xtdplatform.admin")
public class AdminAutoconfig {

    @Bean
    public MenuConfigurer menuConfigurer() {
        return MenuConfigurer.EMPTY;
    }
}
