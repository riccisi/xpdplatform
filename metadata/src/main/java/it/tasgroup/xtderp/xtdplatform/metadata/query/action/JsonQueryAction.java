package it.tasgroup.xtderp.xtdplatform.metadata.query.action;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Result;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.result.JsonResult;
import it.tasgroup.xtderp.xtdplatform.metadata.query.Query;
import it.tasgroup.xtderp.xtdplatform.metadata.query.QueryResult;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class JsonQueryAction extends QueryAction {

    public JsonQueryAction(Query query) {
        super(query);
    }

    @Override
    public String id() {
        return String.format("%s.json", this.query.id());
    }

    @Override
    Result wrap(QueryResult queryResult) {
        return new JsonResult(queryResult);
    }
}