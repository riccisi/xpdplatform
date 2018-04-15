package it.tasgroup.xtderp.xtdplatform.core.menu.model;

import it.tasgroup.xtderp.xtdplatform.core.action.Action;
import org.springframework.util.StringUtils;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public final class DefaultMenuBuilder implements MenuBuilder {

    private final DefaultMenuFolder root = new DefaultMenuFolder("root");

    @Override
    public void add(final String path, final Action action) {
        DefaultMenuBuilder.checkPath(path);
        checkArgument(!this.root.hasItem(path), "Menu Item already exists: %s", path);
        final DefaultMenuFolder folder = path.indexOf('.') == -1 ? this.root : this.addFolder(path.substring(0, path.lastIndexOf('.')));
        final String code = path.indexOf('.') == -1 ? path : path.substring(path.lastIndexOf('.') + 1);
        final String nodePath = String.format("%s.%s",folder.code(),code) ;
        final MenuNode item = new DefaultMenuItem(nodePath, action);
        folder.add(item);
    }

    @Override
    public MenuFolder build() {
        return this.root;
    }

    private DefaultMenuFolder addFolder(final String path) {
        DefaultMenuBuilder.checkPath(path);
        String nodePath = "";
        DefaultMenuFolder parent = this.root;
        for(StringTokenizer tt = new StringTokenizer(path, "."); tt.hasMoreTokens(); ) {
            String code = tt.nextToken().trim();
            checkArgument(!StringUtils.isEmpty(code), "menu id must be not empty!");
            nodePath += StringUtils.isEmpty(nodePath) ? code : '.' + code;
            checkArgument(!parent.hasItem(nodePath), "Node %s is already an item, connot be used as folder");
            final DefaultMenuFolder folder;
            if (parent.hasFolder(nodePath)) {
                folder = (DefaultMenuFolder) parent.get(nodePath);
            } else {
                folder = new DefaultMenuFolder(nodePath);
                parent.add(folder);
            }
            parent = folder;
        }
        return parent;
    }

    private static void checkPath(final String path) {
        checkNotNull(path, "menu path must be not null!");
        checkArgument(!StringUtils.isEmpty(path), "menu path must be not empty!");
        checkArgument(!path.trim().endsWith("."), "menu path must not end with .!");
        checkArgument(!path.trim().startsWith("."), "menu path must not start with .!");
        checkArgument(Pattern.compile("[.A-Za-z0-9]+").matcher(path).matches(), "menu path should contains only valid chars!");
    }
}
