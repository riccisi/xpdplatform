package it.tasgroup.xtderp.xtdplatform.metadata.query.action;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Result;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.result.CsvResult;
import it.tasgroup.xtderp.xtdplatform.metadata.query.Query;
import it.tasgroup.xtderp.xtdplatform.metadata.query.QueryResult;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class CsvQueryAction extends QueryAction {

    public CsvQueryAction(Query query) {
        super(query);
    }

    @Override
    public String id() {
        return String.format("%s.csv", this.query.id());
    }

    @Override
    Result wrap(QueryResult queryResult) {
        return new CsvResult(queryResult);
    }
}