package it.tasgroup.xtderp.xtdplatform.metadata.query;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import lombok.RequiredArgsConstructor;
import org.cactoos.list.ListOf;

import java.util.Iterator;
import java.util.List;

/**
 * Result of a QueryAction that encapsulate a collection of returned data.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0 *
 * @param <T> The type of data returned by the query.
 */
@RequiredArgsConstructor
public class ListQueryResult<T> implements QueryResult<T> {

    private final List<T> results;

    public ListQueryResult(Iterable<T> results) {
        this(new ListOf<T>(results));
    }

    @Override
    public void printOn(Media media) throws Exception {
        media.list().with(this.results);
    }

    @Override
    public Iterator<T> iterator() {
        return this.results.iterator();
    }
}