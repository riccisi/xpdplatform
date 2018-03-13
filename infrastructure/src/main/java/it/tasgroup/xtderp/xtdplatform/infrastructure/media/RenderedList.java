package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface RenderedList<T> extends Rendered<T> {

    RenderedList<T> with(Collection<Printable> printables);

    RenderedList<T> with(Printable... v);

    // @todo #1 add RenderedPrimitive to handle primitives as root
}