package it.tasgroup.xtderp.xtdplatform.core.menu.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

import static com.google.common.base.Preconditions.checkNotNull;

public final class DefaultMenuFolder extends AbstractMenuNode implements MenuFolder {

    private final Collection<MenuNode> children = new LinkedHashSet<>();

    public DefaultMenuFolder(final String code) {
        super(code);
    }

    @Override
    public void accept(final MenuNodeVisitor visitor) {
        visitor.visit(this);
        for(final MenuNode child : this.children) {
            child.accept(visitor);
        }
        visitor.endVisit(this);
    }

    @Override
    public Iterator<MenuNode> iterator() {
        return this.children.iterator();
    }

    public void add(final MenuNode menuNode) {
        this.children.add(menuNode);
    }

    public boolean hasItem(final String path) {
        final MenuNode found = this.get(path);
        return found instanceof DefaultMenuItem;
    }

    public boolean hasFolder(final String path) {
        final MenuNode found = this.get(path);
        return found instanceof DefaultMenuFolder;
    }

    public MenuNode get(final String path) {
        final NodeFinder finder = new NodeFinder(path);
        this.accept(finder);
        return finder.found;
    }

    private static final class NodeFinder extends AbstractMenuNodeVisitor {

        private final String path;
        private MenuNode found;

        NodeFinder(final String path) {
            checkNotNull(path, "path to find must be not null");
            this.path = path;
        }

        void visitNode(final MenuNode menuNode) {
            if(this.path.equals(menuNode.code())) {
                this.found = menuNode;
            }
        }

        @Override
        public void visit(final MenuFolder menuNode) {
            this.visitNode(menuNode);
        }

        @Override
        public void visit(final MenuItem menuNode) {
            this.visitNode(menuNode);
        }

    }
}
