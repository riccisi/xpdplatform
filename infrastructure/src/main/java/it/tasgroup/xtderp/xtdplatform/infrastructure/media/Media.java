package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public interface Media<T> {

    RenderedObject<T> asObject();

    RenderedList<T> asList();

    Rendered<T> as(byte value);

    Rendered<T> as(boolean value);

    Rendered<T> as(short value);

    Rendered<T> as(int value);

    Rendered<T> as(long value);

    Rendered<T> as(float value);

    Rendered<T> as(double value);

    Rendered<T> as(String value);

    Rendered<T> as(Date value);

    Rendered<T> as(BigDecimal value);

    Rendered<T> as(BigInteger value);
}
