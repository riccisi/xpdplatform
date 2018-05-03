package it.tasgroup.xtderp.xtdplatform.core.menu;

import it.tasgroup.xtderp.xtdplatform.core.action.ActionCoordinate;
import it.tasgroup.xtderp.xtdplatform.core.localization.I18n;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class DefaultMenuBuilder implements MenuBuilder{

    private final MenuNode root = new DefaultMenuNode("root");
    private final I18n i18n;

    @Override
    public MenuNode add(final String path, final ActionCoordinate coordinate) {
        checkPath(path);
        final MenuNode parent = this.findParent(path);
        final MenuNode child = new I18nMenuNode(new DefaultMenuNode(path, coordinate), this.i18n);
        parent.add(child);
        return child;
    }

    private MenuNode findParent(final String path) {
        final String parentPath = path.indexOf('.') == -1 ? "root" : path.substring(0, path.lastIndexOf('.'));
        final FoundNodeVisitor visitor = new FoundNodeVisitor(parentPath);
        this.root.accept(visitor);
        MenuNode node = visitor.found();
        if(!visitor.hasFound()) {
            node = this.add(parentPath);
        }
        return node;
    }

    @Override
    public MenuNode build() {
        return this.root;
    }

    private static void checkPath(final String path) {
        checkNotNull(path, "menu path must be not null!");
        checkArgument(!StringUtils.isEmpty(path), "menu path must be not empty!");
        checkArgument(!path.trim().endsWith("."), "menu path must not end with .!");
        checkArgument(!path.trim().startsWith("."), "menu path must not start with .!");
        checkArgument(Pattern.compile("[.A-Za-z0-9]+").matcher(path).matches(), "menu path should contains only valid chars!");
    }

}