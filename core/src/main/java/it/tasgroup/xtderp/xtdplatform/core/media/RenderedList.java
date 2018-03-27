package it.tasgroup.xtderp.xtdplatform.core.media;

import org.cactoos.list.ListOf;
import org.cactoos.list.Mapped;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface RenderedList<T> extends Rendered<T> {

    RenderedList<T> with(List<Printable> printables);

    default RenderedList<T> with(Printable... v) {
        return this.with(Arrays.asList(v));
    }

    default RenderedList<T> with(String... value) {
        return with(new Mapped<>(PrintableString::new, new ListOf<>(value)));
    }
    
    default RenderedList<T> with(Integer... value) {
        return with(new Mapped<>(PrintableInt::new, new ListOf<>(value)));
    }
    
    default RenderedList<T> with(Long... value) {
        return with(new Mapped<>(PrintableLong::new, new ListOf<>(value)));
    }
    
    default RenderedList<T> with(Float... value) {
        return with(new Mapped<>(PrintableFloat::new, new ListOf<>(value)));
    }
    
    default RenderedList<T> with(BigInteger... value) {
        return with(new Mapped<>(PrintableBigInteger::new, new ListOf<>(value)));
    }
    
    default RenderedList<T> with(Double... value) {
        return with(new Mapped<>(PrintableDouble::new, new ListOf<>(value)));
    }
    
    default RenderedList<T> with(Character... value) {
        return with(new Mapped<>(PrintableChar::new, new ListOf<>(value)));
    }
    
    default RenderedList<T> with(Date... value) {
        return with(new Mapped<>(PrintableDate::new, new ListOf<>(value)));
    }
    
    default RenderedList<T> with(BigDecimal... value) {
        return with(new Mapped<>(PrintableBigDecimal::new, new ListOf<>(value)));
    }
    
    default RenderedList<T> with(Byte... value) {
        return with(new Mapped<>(PrintableByte::new, new ListOf<>(value)));
    }
    
    default RenderedList<T> with(Boolean... value) {
        return with(new Mapped<>(PrintableBoolean::new, new ListOf<>(value)));
    }
    
    default RenderedList<T> with(Short... value) {
        return with(new Mapped<>(PrintableShort::new, new ListOf<>(value)));
    }
}