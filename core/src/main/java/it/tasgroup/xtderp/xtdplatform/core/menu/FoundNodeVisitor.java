package it.tasgroup.xtderp.xtdplatform.core.menu;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class FoundNodeVisitor implements MenuNodeVisitor {

    @NonNull private final String path;
    private MenuNode found;

    @Override
    public void visit(final MenuNode node) {
        if(node.path().equalsIgnoreCase(this.path)) {
            this.found = node;
        }
    }

    public boolean hasFound() {
        return this.found != null;
    }

    public MenuNode found() {
        return this.found;
    }
}