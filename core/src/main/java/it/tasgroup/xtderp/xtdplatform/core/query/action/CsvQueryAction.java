package it.tasgroup.xtderp.xtdplatform.core.query.action;

import it.tasgroup.xtderp.xtdplatform.core.action.Result;
import it.tasgroup.xtderp.xtdplatform.core.action.result.CsvResult;
import it.tasgroup.xtderp.xtdplatform.core.query.Query;
import it.tasgroup.xtderp.xtdplatform.core.query.QueryResult;

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
    public String id() throws Exception {
        return String.format("%s.csv", this.query.id());
    }

    @Override
    Result wrap(QueryResult queryResult) {
        return new CsvResult(queryResult);
    }
}