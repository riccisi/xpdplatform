package it.tasgroup.xtderp.xtdplatform.core.media.txt;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.core.media.RenderedList;
import it.tasgroup.xtderp.xtdplatform.core.media.RenderedObject;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class TxtMedia implements Media<String> {

    @Override
    public RenderedObject<String> asObject() {
        throw new UnsupportedOperationException("#asObject()");
    }

    @Override
    public RenderedList<String> asList() {
        throw new UnsupportedOperationException("#asList()");
    }

    @Override
    public Rendered<String> as(final Byte value) {
        return new NullSafeTxtRendered(value, new TxtRenderedNumber(value));
    }

    @Override
    public Rendered<String> as(final Boolean value) {
        return new NullSafeTxtRendered(value, new TxtRenderedBoolean(value));
    }

    @Override
    public Rendered<String> as(final Character value) {
        return new NullSafeTxtRendered(value, new TxtRenderedString(value));
    }

    @Override
    public Rendered<String> as(final Short value) {
        return new NullSafeTxtRendered(value, new TxtRenderedNumber(value));
    }

    @Override
    public Rendered<String> as(final Integer value) {
        return new NullSafeTxtRendered(value, new TxtRenderedNumber(value));
    }

    @Override
    public Rendered<String> as(final Long value) {
        return new NullSafeTxtRendered(value, new TxtRenderedNumber(value));
    }

    @Override
    public Rendered<String> as(final Float value) {
        return new NullSafeTxtRendered(value, new TxtRenderedNumber(value));
    }

    @Override
    public Rendered<String> as(final Double value) {
        return new NullSafeTxtRendered(value, new TxtRenderedNumber(value));
    }

    @Override
    public Rendered<String> as(final String value) {
        return new NullSafeTxtRendered(value, new TxtRenderedString(value));
    }

    @Override
    public Rendered<String> as(final Date value) {
        return new NullSafeTxtRendered(value, new TxtRenderedDate(value));
    }

    @Override
    public Rendered<String> as(final BigDecimal value) {
        return new NullSafeTxtRendered(value, new TxtRenderedNumber(value));
    }

    @Override
    public Rendered<String> as(final BigInteger value) {
        return new NullSafeTxtRendered(value, new TxtRenderedNumber(value));
    }


}
