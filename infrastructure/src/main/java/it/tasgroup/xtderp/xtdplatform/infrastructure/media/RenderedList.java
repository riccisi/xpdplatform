package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface RenderedList extends Rendered {

    RenderedList with(Collection<Printable> printables);

    RenderedList with(Printable... v);

}