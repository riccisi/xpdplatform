package it.tasgroup.xtderp.xtdplatform.core.media;

import org.cactoos.list.ListOf;

import java.math.BigDecimal;
import java.math.BigInteger;
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

    RenderedObject<T> with(String key, Printable val);

    default RenderedObject<T> with(final String key, final String val) {
        return this.with(key, new PrintableString(val));
    }

    default RenderedObject<T> with(final String key, final byte val) {
        return this.with(key, new PrintableByte(val));
    }

    default RenderedObject<T> with(final String key, final short val) {
        return this.with(key, new PrintableShort(val));
    }

    default RenderedObject<T> with(final String key, final int val) {
        return this.with(key, new PrintableInt(val));
    }

    default RenderedObject<T> with(final String key, final long val) {
        return this.with(key, new PrintableLong(val));
    }

    default RenderedObject<T> with(final String key, final float val) {
        return this.with(key, new PrintableFloat(val));
    }

    default RenderedObject<T> with(final String key, final double val) {
        return this.with(key, new PrintableDouble(val));
    }

    default RenderedObject<T> with(final String key, final boolean val) {
        return this.with(key, new PrintableBoolean(val));
    }

    default RenderedObject<T> with(final String key, final char val) {
        return this.with(key, new PrintableChar(val));
    }

    default RenderedObject<T> with(final String key, final Date val) {
        return this.with(key, new PrintableDate(val));
    }

    default RenderedObject<T> with(final String key, final BigDecimal val) {
        return this.with(key, new PrintableBigDecimal(val));
    }

    default RenderedObject<T> with(final String key, final BigInteger val) {
        return this.with(key, new PrintableBigInteger(val));
    }

    default RenderedObject<T> with(final String key, final List<Printable> val) {
        return this.with(key, new PrintableList(val));
    }

    default RenderedObject<T> with(final String key, final String... val) {
        return this.with(key, new PrintableList(new ListOf<>(val), PrintableString::new));
    }
}
