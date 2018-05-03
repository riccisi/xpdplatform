package it.tasgroup.xtderp.xtdplatform.core.menu;

import it.tasgroup.xtderp.xtdplatform.core.action.ActionCoordinate;
import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.RenderedObject;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
public interface MenuNode extends Printable, Iterable<MenuNode> {

    String path();

    ActionCoordinate action();

    void accept(MenuNodeVisitor visitor);

    @Override
    <R> RenderedObject<R> print(Media<R> media) throws Exception;

    void add(MenuNode child);
}