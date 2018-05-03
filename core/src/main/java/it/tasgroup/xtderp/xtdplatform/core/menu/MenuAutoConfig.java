package it.tasgroup.xtderp.xtdplatform.core.menu;

import it.tasgroup.xtderp.xtdplatform.core.action.Actions;
import it.tasgroup.xtderp.xtdplatform.core.localization.I18n;
import it.tasgroup.xtderp.xtdplatform.core.menu.parser.MenuNodeDeserializer;
import it.tasgroup.xtderp.xtdplatform.core.menu.service.FlatMenuService;
import it.tasgroup.xtderp.xtdplatform.core.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
@Log
@RequiredArgsConstructor
@SuppressWarnings("DesignForExtension")
public class MenuAutoConfig implements Jackson2ObjectMapperBuilderCustomizer {

    @Bean
    @ConditionalOnMissingBean
    public MenuActions menuActions(final Actions actions) {
        return new DefaultMenuActions(actions);
    }

    @Bean
    @ConditionalOnMissingBean
    public Menu menu(final MenuActions actions, final I18n i18n) {
        return new CachedMenu(new ActionMenu(actions, i18n));
    }

    @Bean
    @ConditionalOnMissingBean
    public FlatMenu flatMenu(final Menu menu, final I18n i18n) {
        return new CachedFlatMenu(new DefaultFlatMenu(menu, i18n));
    }

    @Bean
    public MenuService menuService(final Menu menu) {
        return new MenuService(menu);
    }

    @Bean
    public FlatMenuService flatMenuService(final FlatMenu menu) {
        return new FlatMenuService(menu);
    }

    @Override
    public void customize(final Jackson2ObjectMapperBuilder builder) {
        builder.deserializerByType(MenuNode.class, new MenuNodeDeserializer());
    }
}