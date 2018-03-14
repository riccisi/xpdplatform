package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

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

    private Printable printable;

    public PrintableOf(String value) {
        this.printable = new PrintableString(value);
    }

    public PrintableOf(byte value) {
        this.printable = new PrintableByte(value);
    }

    public PrintableOf(short value) {
        this.printable = new PrintableShort(value);
    }

    public PrintableOf(int value) {
        this.printable = new PrintableInt(value);
    }

    public PrintableOf(long value) {
        this.printable = new PrintableLong(value);
    }

    public PrintableOf(float value) {
        this.printable = new PrintableFloat(value);
    }

    public PrintableOf(double value) {
        this.printable = new PrintableDouble(value);
    }

    public PrintableOf(boolean value) {
        this.printable = new PrintableBoolean(value);
    }

    public PrintableOf(char value) {
        this.printable = new PrintableChar(value);
    }

    public PrintableOf(Date value) {
        this.printable = new PrintableDate(value);
    }

    public PrintableOf(BigDecimal value) {
        this.printable = new PrintableBigDecimal(value);
    }

    public PrintableOf(BigInteger value) {
        this.printable = new PrintableBigInteger(value);
    }

    @Override
    public <T> Rendered<T> print(Media<T> media) {
        return this.printable.print(media);
    }
}
