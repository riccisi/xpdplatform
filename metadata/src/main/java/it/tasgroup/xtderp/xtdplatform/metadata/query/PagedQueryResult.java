package it.tasgroup.xtderp.xtdplatform.metadata.query;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import lombok.RequiredArgsConstructor;
import org.cactoos.list.ListOf;

import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public class PagedQueryResult<T> implements QueryResult<T> {

    private final List<T> results;

    private final int total;

    public PagedQueryResult(Iterable<T> results, int total) {
        this(new ListOf<T>(results), total);
    }

    @Override
    public void printOn(Media media) throws Exception {
        media.with("total", total);
        media.with("result", this.results);
    }

    @Override
    public Iterator<T> iterator() {
        return this.results.iterator();
    }
}
