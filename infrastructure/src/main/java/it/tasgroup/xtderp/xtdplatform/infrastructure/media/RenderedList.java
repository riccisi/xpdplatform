package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface RenderedList<T> extends Rendered<T> {

    RenderedList<T> with(Collection<Printable> printables);

    RenderedList<T> with(Printable... value);

    RenderedList<T> with(Byte... value);

    RenderedList<T> with(Boolean... value);

    RenderedList<T> with(Short... value);

    RenderedList<T> with(Integer... value);

    RenderedList<T> with(Long... value);

    RenderedList<T> with(Float... value);

    RenderedList<T> with(Double... value);

    RenderedList<T> with(Character... value);

    RenderedList<T> with(String... value);

    RenderedList<T> with(Date... value);

    RenderedList<T> with(BigDecimal... value);

    RenderedList<T> with(BigInteger... value);
}