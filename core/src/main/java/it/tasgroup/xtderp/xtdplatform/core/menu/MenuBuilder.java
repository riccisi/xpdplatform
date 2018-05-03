package it.tasgroup.xtderp.xtdplatform.core.menu;

import it.tasgroup.xtderp.xtdplatform.core.action.ActionCoordinate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
public interface MenuBuilder {

    MenuNode add(String path, ActionCoordinate coordinate);

    default MenuNode add(String path) {
        return this.add(path, new ActionCoordinate.Empty());
    }

    MenuNode build();
}
