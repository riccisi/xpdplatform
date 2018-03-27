package it.tasgroup.xtderp.xtdplatform.proxy.menu;

import it.tasgroup.xtderp.xtdplatform.core.menu.model.*;
import lombok.RequiredArgsConstructor;

import java.util.Iterator;

@RequiredArgsConstructor
public class AggregatedMenu implements Menu {

   private final Menus menus;

    @Override
    public Iterator<MenuNode> iterator() {
        DefaultMenuBuilder menuBuilder = new DefaultMenuBuilder();
        for (Menu menu : menus) {
            for (MenuNode menuNode : menu) {
                menuNode.accept(new AbstractMenuNodeVisitor() {
                    @Override
                    public void visit(MenuItem leaf) {
                        menuBuilder.add(leaf.code(), leaf.action());
                    }
                });
            }
        }
        return menuBuilder.build().iterator();
    }
}
