package it.tasgroup.xtderp.xtdplatform.core.menu.model;

public interface MenuNodeVisitor {

    void visit(MenuFolder menuNode);

    void visit(MenuItem menuNode);

    void endVisit(MenuFolder menuNode);
}
