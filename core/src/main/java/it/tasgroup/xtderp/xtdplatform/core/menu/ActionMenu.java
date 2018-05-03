package it.tasgroup.xtderp.xtdplatform.core.menu;

import it.tasgroup.xtderp.xtdplatform.core.action.SimpleActionCoordinate;
import it.tasgroup.xtderp.xtdplatform.core.localization.I18n;
import lombok.NonNull;
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

    @NonNull private final MenuActions actions;
    @NonNull private final I18n i18n;

    @Override
    public Iterator<MenuNode> iterator() {
        final MenuBuilder builder = new DefaultMenuBuilder(this.i18n);
        this.actions.forEach(action -> builder.add(action.path(), new SimpleActionCoordinate(action)));
        return builder.build().iterator();
    }
}