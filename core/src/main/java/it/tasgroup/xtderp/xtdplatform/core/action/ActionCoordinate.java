package it.tasgroup.xtderp.xtdplatform.core.action;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
public interface ActionCoordinate extends Printable {

    final class Empty implements ActionCoordinate {

        @Override
        public <R> Rendered<R> print(final Media<R> media) {
            return media.as(false);
        }
    }
}