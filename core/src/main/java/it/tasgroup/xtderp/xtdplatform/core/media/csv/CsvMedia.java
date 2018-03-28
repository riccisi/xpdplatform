package it.tasgroup.xtderp.xtdplatform.core.media.csv;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.core.media.RenderedList;
import it.tasgroup.xtderp.xtdplatform.core.media.RenderedObject;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class CsvMedia implements Media<CsvObject> {

    @Override
    public RenderedObject<CsvObject> asObject() {
        return new CsvRenderedObject();
    }

    @Override
    public RenderedList<CsvObject> asList() {
        return new CsvRenderedList();
    }

    @Override
    public Rendered<CsvObject> as(Byte value) {
        throw new UnsupportedOperationException("#as()");
    }

    @Override
    public Rendered<CsvObject> as(Boolean value) {
        throw new UnsupportedOperationException("#as()");
    }

    @Override
    public Rendered<CsvObject> as(Character value) {
        throw new UnsupportedOperationException("#as()");
    }

    @Override
    public Rendered<CsvObject> as(Short value) {
        throw new UnsupportedOperationException("#as()");
    }

    @Override
    public Rendered<CsvObject> as(Integer value) {
        throw new UnsupportedOperationException("#as()");
    }

    @Override
    public Rendered<CsvObject> as(Long value) {
        throw new UnsupportedOperationException("#as()");
    }

    @Override
    public Rendered<CsvObject> as(Float value) {
        throw new UnsupportedOperationException("#as()");
    }

    @Override
    public Rendered<CsvObject> as(Double value) {
        throw new UnsupportedOperationException("#as()");
    }

    @Override
    public Rendered<CsvObject> as(String value) {
        throw new UnsupportedOperationException("#as()");
    }

    @Override
    public Rendered<CsvObject> as(Date value) {
        throw new UnsupportedOperationException("#as()");
    }

    @Override
    public Rendered<CsvObject> as(BigDecimal value) {
        throw new UnsupportedOperationException("#as()");
    }

    @Override
    public Rendered<CsvObject> as(BigInteger value) {
        throw new UnsupportedOperationException("#as()");
    }


}
