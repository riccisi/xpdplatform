package it.tasgroup.xtderp.xtdplatform.core.menu.model;

public interface MenuNode {

    String code();

    void accept(MenuNodeVisitor visitor);

}
