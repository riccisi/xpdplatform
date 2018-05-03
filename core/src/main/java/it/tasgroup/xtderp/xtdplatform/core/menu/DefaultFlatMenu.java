package it.tasgroup.xtderp.xtdplatform.core.menu;

import it.tasgroup.xtderp.xtdplatform.core.localization.I18n;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class DefaultFlatMenu implements FlatMenu, MenuNodeVisitor {

    private final Menu menu;
    private final I18n i18n;
    private final Collection<MenuItem> items = new ArrayList<>();

    @Override
    public Iterator<MenuItem> iterator() {
        for (final MenuNode node : this.menu) {
            node.accept(this);
        }
        return this.items.iterator();
    }

    @Override
    public void visit(final MenuNode node) {
        this.items.add(new I18nMenuItem(new DefaultMenuItem(node), this.i18n));
    }
}