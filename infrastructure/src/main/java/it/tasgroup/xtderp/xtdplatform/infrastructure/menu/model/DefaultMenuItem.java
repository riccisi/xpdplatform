package it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Action;

public final class DefaultMenuItem extends AbstractMenuNode implements MenuItem {

    private final Action action;

    public DefaultMenuItem(String code, Action action) {
        super(code);
        this.action = action;
    }

    @Override
    public void accept(MenuNodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Action action() {
        return this.action;
    }
}
