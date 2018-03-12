package it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Action;

public interface MenuBuilder {

    void add(String path, Action action);

    MenuNode build();
}
