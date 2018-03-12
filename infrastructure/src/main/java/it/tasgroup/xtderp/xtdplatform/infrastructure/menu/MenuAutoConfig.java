package it.tasgroup.xtderp.xtdplatform.infrastructure.menu;

import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.CachedMenu;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.ConfigurableMenu;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.Menu;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.MenuConfigurer;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.MenuFolder;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.MenuItem;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.MenuNode;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.parser.MenuFolderSerializer;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.parser.MenuItemSerializer;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.parser.MenuNodeDeserializer;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.service.MenuService;
import lombok.extern.java.Log;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.util.List;

@Configuration
@Log
public class MenuAutoConfig implements Jackson2ObjectMapperBuilderCustomizer {

    @Bean
    @Order
    @ConditionalOnMissingBean
    public MenuConfigurer menuConfigurer() {
        log.warning("No menu configurer has been defined!");
        return MenuConfigurer.EMPTY;
    }

    @Bean
    @ConditionalOnMissingBean
    public Menu menu(List<MenuConfigurer> configurers) {
        return new CachedMenu(new ConfigurableMenu(configurers));
    }

    @Bean
    public MenuService menuService(Menu menu) {
        return new MenuService(menu);
    }

    @Override
    public void customize(Jackson2ObjectMapperBuilder builder) {
        builder.serializerByType(MenuFolder.class, new MenuFolderSerializer());
        builder.serializerByType(MenuItem.class, new MenuItemSerializer());
        builder.deserializerByType(MenuNode.class, new MenuNodeDeserializer());
    }
}