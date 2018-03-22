package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

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

    RenderedObject<T> with(String k, Printable v);

    default RenderedObject<T> with(String k, String v) {
        return this.with(k, new PrintableString(v));
    }

    default RenderedObject<T> with(String k, byte v) {
        return this.with(k, new PrintableByte(v));
    }

    default RenderedObject<T> with(String k, short v) {
        return this.with(k, new PrintableShort(v));
    }

    default RenderedObject<T> with(String k, int v) {
        return this.with(k, new PrintableInt(v));
    }

    default RenderedObject<T> with(String k, long v) {
        return this.with(k, new PrintableLong(v));
    }

    default RenderedObject<T> with(String k, float v) {
        return this.with(k, new PrintableFloat(v));
    }

    default RenderedObject<T> with(String k, double v) {
        return this.with(k, new PrintableDouble(v));
    }

    default RenderedObject<T> with(String k, boolean v) {
        return this.with(k, new PrintableBoolean(v));
    }

    default RenderedObject<T> with(String k, char v) {
        return this.with(k, new PrintableChar(v));
    }

    default RenderedObject<T> with(String k, Date v) {
        return this.with(k, new PrintableDate(v));
    }

    default RenderedObject<T> with(String k, BigDecimal v) {
        return this.with(k, new PrintableBigDecimal(v));
    }

    default RenderedObject<T> with(String k, BigInteger v) {
        return this.with(k, new PrintableBigInteger(v));
    }

    default RenderedObject<T> with(String k, List<Printable> v) {
        return this.with(k, new PrintableList(v));
    }

    default RenderedObject<T> with(String k, String... v) {
        return this.with(k, new PrintableList(new ListOf<>(v), PrintableString::new));
    }
}
