package it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model;

public interface MenuNode {

    String code();

    void accept(MenuNodeVisitor visitor);

}
