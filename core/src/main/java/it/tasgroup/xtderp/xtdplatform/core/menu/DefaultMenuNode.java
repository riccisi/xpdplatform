package it.tasgroup.xtderp.xtdplatform.core.menu;

import it.tasgroup.xtderp.xtdplatform.core.action.ActionCoordinate;
import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.RenderedObject;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class DefaultMenuNode implements MenuNode {

    @NonNull private final String path;
    @NonNull private final ActionCoordinate coordinate;
    private final List<MenuNode> children = new ArrayList<>();

    public DefaultMenuNode(final String path) {
        this(path, new ActionCoordinate.Empty());
    }

    @Override
    public String path() {
        return this.path;
    }

    @Override
    public ActionCoordinate action() {
        return this.coordinate;
    }

    @Override
    public void accept(final MenuNodeVisitor visitor) {
        visitor.visit(this);
        for (final MenuNode node : this) {
            node.accept(visitor);
        }
    }

    @Override
    public <R> RenderedObject<R> print(final Media<R> media) {
        return media.asObject()
            .with("id", this.path())
            .with("folder", !this.children.isEmpty())
            .with("leaf", this.children.isEmpty())
            .with("children", new ArrayList<>(this.children))
            .with("coordinate", this.coordinate);
    }

    @Override
    public Iterator<MenuNode> iterator() {
        return this.children.iterator();
    }

    @Override
    public void add(final MenuNode child) {
        this.children.add(child);
    }
}