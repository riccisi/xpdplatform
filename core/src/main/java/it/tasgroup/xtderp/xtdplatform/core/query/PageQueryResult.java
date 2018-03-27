package it.tasgroup.xtderp.xtdplatform.core.query;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import lombok.NonNull;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class PageQueryResult extends QueryResult {

    private final long total;

    public PageQueryResult(List<Printable> result, long total) {
        super(result);
        this.total = total;
    }

    @Override
    public <R> Rendered<R> print(Media<R> media) {
        return media.asObject()
            .with("result", result)
            .with("total", total);
    }
}