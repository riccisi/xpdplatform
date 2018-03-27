package it.tasgroup.xtderp.xtdplatform.core.menu.model;

/**
 * Convenience class, intentionally left blank, to avoid the implementation of all the methods
 * to the MenuNodeVisitor implementers.
 */
public abstract class AbstractMenuNodeVisitor implements MenuNodeVisitor {

    @Override
    public void visit(MenuFolder menuNode) {
    }

    @Override
    public void visit(MenuItem menuNode) {
    }

    @Override
    public void endVisit(MenuFolder menuNode) {
    }
}