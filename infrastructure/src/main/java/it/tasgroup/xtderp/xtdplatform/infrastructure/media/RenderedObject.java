package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface RenderedObject<T> extends Rendered<T> {

    RenderedObject<T> with(String k, String v);

    RenderedObject<T> with(String k, byte v);

    RenderedObject<T> with(String k, short v);

    RenderedObject<T> with(String k, int v);

    RenderedObject<T> with(String k, long v);

    RenderedObject<T> with(String k, float v);

    RenderedObject<T> with(String k, double v);

    RenderedObject<T> with(String k, boolean v);

    RenderedObject<T> with(String k, char v);

    RenderedObject<T> with(String k, Number v);

    RenderedObject<T> with(String k, Date v);

    RenderedObject<T> with(String k, BigDecimal v);

    RenderedObject<T> with(String k, BigInteger v);

    RenderedObject<T> with(String k, List<Printable> v);

    RenderedObject<T> with(String k, String... v);

    RenderedObject<T> with(String k, Printable v);
}
