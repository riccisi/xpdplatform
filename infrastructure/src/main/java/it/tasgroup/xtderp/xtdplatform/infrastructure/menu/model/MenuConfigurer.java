package it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model;

public interface MenuConfigurer {

    MenuConfigurer EMPTY = menuBuilder -> {};

    void configure(MenuBuilder menuBuilder);
}
