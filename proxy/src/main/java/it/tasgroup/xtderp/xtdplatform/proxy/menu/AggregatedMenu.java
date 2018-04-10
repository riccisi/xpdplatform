package it.tasgroup.xtderp.xtdplatform.proxy.menu;

import it.tasgroup.xtderp.xtdplatform.core.menu.model.*;
import lombok.RequiredArgsConstructor;

import java.util.Iterator;

@RequiredArgsConstructor
public final class AggregatedMenu implements Menu {

   private final Menus menus;

    @Override
    public Iterator<MenuNode> iterator() {
        final MenuBuilder builder = new DefaultMenuBuilder();
        for (final Menu menu : this.menus) {
            for (final MenuNode node : menu) {
                node.accept(new AbstractMenuNodeVisitor() {
                    @Override
                    public void visit(final MenuItem leaf) {
                        builder.add(leaf.code(), leaf.action());
                    }
                });
            }
        }
        return builder.build().iterator();
    }
}