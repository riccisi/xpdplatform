package it.tasgroup.xtderp.xtdplatform.infrastructure.media.csv;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.RenderedList;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.RenderedObject;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public class CsvMedia implements Media {

    @Override
    public RenderedObject object() {
        throw new UnsupportedOperationException("#object()");
    }

    @Override
    public RenderedList list() {
        throw new UnsupportedOperationException("#list()");
    }
}
