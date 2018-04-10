package it.tasgroup.xtderp.xtdplatform.core.menu.model;

import it.tasgroup.xtderp.xtdplatform.core.menu.MenuActions;
import lombok.RequiredArgsConstructor;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class ActionMenu implements Menu {

    private final MenuActions actions;

    @Override
    public Iterator<MenuNode> iterator() {
        final MenuBuilder builder = new DefaultMenuBuilder();
        this.actions.forEach(action -> builder.add(action.path(), action));
        return builder.build().iterator();
    }
}