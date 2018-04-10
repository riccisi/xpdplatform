package it.tasgroup.xtderp.xtdplatform.core.menu.model;

import it.tasgroup.xtderp.xtdplatform.core.action.Action;

public interface MenuBuilder {

    void add(String path, Action action);

    MenuFolder build();
}
