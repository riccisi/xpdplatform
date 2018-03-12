package it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

public final class DefaultMenuFolder extends AbstractMenuNode implements MenuFolder {

    private final Set<MenuNode> children = new LinkedHashSet<>();

    public DefaultMenuFolder(String code) {
        super(code);
    }

    @Override
    public void accept(MenuNodeVisitor visitor) {
        visitor.visit(this);
        for(MenuNode child : this.children) {
            child.accept(visitor);
        }
        visitor.endVisit(this);
    }

    @Override
    public Iterator<MenuNode> iterator() {
        return this.children.iterator();
    }

    public void add(MenuNode menuNode) {
        this.children.add(menuNode);
    }

    public boolean hasItem(String path) {
        MenuNode found = this.get(path);
        return found != null && found instanceof DefaultMenuItem;
    }

    public boolean hasFolder(String path) {
        MenuNode found = this.get(path);
        return found != null && found instanceof DefaultMenuFolder;
    }

    public MenuNode get(String path) {
        NodeFinder finder = new NodeFinder(path);
        accept(finder);
        return finder.found;
    }

    private static class NodeFinder extends AbstractMenuNodeVisitor {

        private String path;
        private MenuNode found = null;

        NodeFinder(String path) {
            checkNotNull(path, "path to find must be not null");
            this.path = path;
        }

        void visitNode(MenuNode menuNode) {
            if(path.equals(menuNode.code())) {
                this.found = menuNode;
            }
        }

        @Override
        public void visit(MenuFolder menuNode) {
            this.visitNode(menuNode);
        }

        @Override
        public void visit(MenuItem menuNode) {
            this.visitNode(menuNode);
        }

    }
}
