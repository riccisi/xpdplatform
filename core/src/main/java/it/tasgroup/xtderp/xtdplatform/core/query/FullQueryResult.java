package it.tasgroup.xtderp.xtdplatform.core.query;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class FullQueryResult extends QueryResult {

    public FullQueryResult(List<Printable> result) {
        super(result);
    }

    @Override
    public <R> Rendered<R> print(Media<R> media) {
        return media.asList().with(result);
    }
}