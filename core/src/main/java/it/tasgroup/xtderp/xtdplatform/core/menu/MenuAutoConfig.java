package it.tasgroup.xtderp.xtdplatform.core.menu;

import it.tasgroup.xtderp.xtdplatform.core.action.Actions;
import it.tasgroup.xtderp.xtdplatform.core.menu.model.*;
import it.tasgroup.xtderp.xtdplatform.core.menu.parser.MenuFolderSerializer;
import it.tasgroup.xtderp.xtdplatform.core.menu.parser.MenuItemSerializer;
import it.tasgroup.xtderp.xtdplatform.core.menu.parser.MenuNodeDeserializer;
import it.tasgroup.xtderp.xtdplatform.core.menu.service.MenuService;
import lombok.extern.java.Log;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
@Log
@SuppressWarnings("DesignForExtension")
public class MenuAutoConfig implements Jackson2ObjectMapperBuilderCustomizer {

    @Bean
    @ConditionalOnMissingBean
    public MenuActions menuActions(final Actions actions) {
        return new DefaultMenuActions(actions);
    }

    @Bean
    @ConditionalOnMissingBean
    public Menu menu(final MenuActions actions) {
        return new CachedMenu(new ActionMenu(actions));
    }

    @Bean
    public MenuService menuService(final Menu menu) {
        return new MenuService(menu);
    }

    @Override
    public void customize(final Jackson2ObjectMapperBuilder builder) {
        builder.serializerByType(MenuFolder.class, new MenuFolderSerializer());
        builder.serializerByType(MenuItem.class, new MenuItemSerializer());
        builder.deserializerByType(MenuNode.class, new MenuNodeDeserializer());
    }
}