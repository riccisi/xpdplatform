package it.tasgroup.xtderp.xtdplatform.core.menu.model;

public interface MenuConfigurer {

    MenuConfigurer EMPTY = menuBuilder -> {};

    void configure(MenuBuilder menuBuilder);
}
