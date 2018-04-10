package it.tasgroup.xtderp.xtdplatform.core.menu.model;

import it.tasgroup.xtderp.xtdplatform.core.action.Action;

public final class DefaultMenuItem extends AbstractMenuNode implements MenuItem {

    private final Action action;

    public DefaultMenuItem(final String code, final Action action) {
        super(code);
        this.action = action;
    }

    @Override
    public void accept(final MenuNodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Action action() {
        return this.action;
    }
}