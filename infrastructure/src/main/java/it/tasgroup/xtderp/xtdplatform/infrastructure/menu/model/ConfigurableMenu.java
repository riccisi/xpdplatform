package it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model;

import lombok.RequiredArgsConstructor;

import java.util.Iterator;

/**
 * Implementation of a a menu which delegates its construction to a set of configurers.
 */
@RequiredArgsConstructor
public final class ConfigurableMenu implements Menu {

    private final Iterable<MenuConfigurer> configurers;

    @Override
    public Iterator<MenuNode> iterator() {
        DefaultMenuBuilder menuBuilder = new DefaultMenuBuilder();
        this.configurers.forEach(configurer -> configurer.configure(menuBuilder));
        return menuBuilder.build().iterator();
    }

}