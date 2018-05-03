package it.tasgroup.xtderp.xtdplatform.proxy.menu;

import it.tasgroup.xtderp.xtdplatform.core.localization.I18n;
import it.tasgroup.xtderp.xtdplatform.core.menu.DefaultMenuBuilder;
import it.tasgroup.xtderp.xtdplatform.core.menu.Menu;
import it.tasgroup.xtderp.xtdplatform.core.menu.MenuBuilder;
import it.tasgroup.xtderp.xtdplatform.core.menu.MenuNode;
import lombok.RequiredArgsConstructor;

import java.util.Iterator;

@RequiredArgsConstructor
public final class AggregatedMenu implements Menu {

   private final Menus menus;
   private final I18n i18n;

    @Override
    public Iterator<MenuNode> iterator() {
        final MenuBuilder builder = new DefaultMenuBuilder(this.i18n);
        for (final Menu menu : this.menus) {
            for (final MenuNode node : menu) {
                node.accept(child -> builder.add(child.path(), child.action()));
            }
        }
        return builder.build().iterator();
    }
}