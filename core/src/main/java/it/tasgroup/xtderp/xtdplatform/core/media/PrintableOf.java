package it.tasgroup.xtderp.xtdplatform.core.media;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

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
@RequiredArgsConstructor
@EqualsAndHashCode(of = "printable", callSuper = false)
@ToString(of = "printable")
public final class PrintableOf implements Printable {

    private final Printable printable;

    public PrintableOf(final String value) {
        this.printable = new PrintableString(value);
    }

    public PrintableOf(final byte value) {
        this.printable = new PrintableByte(value);
    }

    public PrintableOf(final short value) {
        this.printable = new PrintableShort(value);
    }

    public PrintableOf(final int value) {
        this.printable = new PrintableInt(value);
    }

    public PrintableOf(final long value) {
        this.printable = new PrintableLong(value);
    }

    public PrintableOf(final float value) {
        this.printable = new PrintableFloat(value);
    }

    public PrintableOf(final double value) {
        this.printable = new PrintableDouble(value);
    }

    public PrintableOf(final boolean value) {
        this.printable = new PrintableBoolean(value);
    }

    public PrintableOf(final char value) {
        this.printable = new PrintableChar(value);
    }

    public PrintableOf(final Date value) {
        this.printable = new PrintableDate(value);
    }

    public PrintableOf(final BigDecimal value) {
        this.printable = new PrintableBigDecimal(value);
    }

    public PrintableOf(final BigInteger value) {
        this.printable = new PrintableBigInteger(value);
    }

    @Override
    public <T> Rendered<T> print(final Media<T> media) throws Exception {
        return this.printable.print(media);
    }
}
