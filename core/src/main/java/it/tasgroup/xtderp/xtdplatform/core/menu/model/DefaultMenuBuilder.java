package it.tasgroup.xtderp.xtdplatform.core.menu.model;

import it.tasgroup.xtderp.xtdplatform.core.action.Action;
import org.springframework.util.StringUtils;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class DefaultMenuBuilder implements MenuBuilder {

    private DefaultMenuFolder rootMenu = new DefaultMenuFolder("root");

    @Override
    public void add(String path, Action action) {
        checkPath(path);
        checkArgument(!this.rootMenu.hasItem(path), "Menu Item already exists: %s", path);
        DefaultMenuFolder folder = path.indexOf('.') != -1 ? this.addFolder(path.substring(0, path.lastIndexOf('.'))) : this.rootMenu;
        String itemCode = path.indexOf('.') != -1 ? path.substring(path.lastIndexOf('.') + 1) : path;
        String nodePath = folder.code() + "." + itemCode;
        DefaultMenuItem menuItem = new DefaultMenuItem(nodePath, action);
        folder.add(menuItem);
    }

    @Override
    public MenuFolder build() {
        return this.rootMenu;
    }

    private DefaultMenuFolder addFolder(String path) {
        checkPath(path);
        String nodePath = "";
        DefaultMenuFolder parent = this.rootMenu;
        for(StringTokenizer tt = new StringTokenizer(path, "."); tt.hasMoreTokens(); ) {
            String code = tt.nextToken().trim();
            checkArgument(!StringUtils.isEmpty(code), "menu id must be not empty!");
            nodePath += (!StringUtils.isEmpty(nodePath) ? "." + code : code);
            checkArgument(!parent.hasItem(nodePath), "Node %s is already an item, connot be used as folder");
            DefaultMenuFolder menuFolder;
            if(!parent.hasFolder(nodePath)) {
                menuFolder = new DefaultMenuFolder(nodePath);
                parent.add(menuFolder);
            } else {
                menuFolder = (DefaultMenuFolder) parent.get(nodePath);
            }
            parent = menuFolder;
        }
        return parent;
    }

    private void checkPath(String path) {
        checkNotNull(path, "menu path must be not null!");
        checkArgument(!StringUtils.isEmpty(path), "menu path must be not empty!");
        checkArgument(!path.trim().endsWith("."), "menu path must not end with .!");
        checkArgument(!path.trim().startsWith("."), "menu path must not start with .!");
        checkArgument(Pattern.compile("[.A-Za-z0-9]+").matcher(path).matches(), "menu path should contains only valid chars!");
    }
}
