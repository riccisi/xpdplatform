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
public interface RenderedObject extends Rendered {

    RenderedObject with(String k, String v);

    RenderedObject with(String k, byte v);

    RenderedObject with(String k, short v);

    RenderedObject with(String k, int v);

    RenderedObject with(String k, long v);

    RenderedObject with(String k, float v);

    RenderedObject with(String k, double v);

    RenderedObject with(String k, boolean v);

    RenderedObject with(String k, char v);

    RenderedObject with(String k, Date v);

    RenderedObject with(String k, BigDecimal v);

    RenderedObject with(String k, BigInteger v);

    RenderedObject with(String k, Collection<Printable> v);

    RenderedObject with(String k, Printable v);
}
