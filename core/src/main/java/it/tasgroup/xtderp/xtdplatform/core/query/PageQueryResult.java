package it.tasgroup.xtderp.xtdplatform.core.query;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class PageQueryResult implements QueryResult {

    private final List<Printable> result;
    private final long total;

    @Override
    public List<Printable> result() {
        return Collections.unmodifiableList(this.result);
    }

    @Override
    public <R> Rendered<R> print(final Media<R> media) {
        return media.asObject()
            .with("result", this.result)
            .with("total", this.total);
    }
}