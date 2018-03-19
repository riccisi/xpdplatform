package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public interface Media<T> {

    RenderedObject<T> asObject();

    RenderedList<T> asList();

    Rendered<T> as(Byte value);

    Rendered<T> as(Boolean value);

    Rendered<T> as(Character value);

    Rendered<T> as(Short value);

    Rendered<T> as(Integer value);

    Rendered<T> as(Long value);

    Rendered<T> as(Float value);

    Rendered<T> as(Double value);

    Rendered<T> as(String value);

    Rendered<T> as(Date value);

    Rendered<T> as(BigDecimal value);

    Rendered<T> as(BigInteger value);
}
