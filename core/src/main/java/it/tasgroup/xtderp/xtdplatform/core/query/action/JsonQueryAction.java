package it.tasgroup.xtderp.xtdplatform.core.query.action;

import it.tasgroup.xtderp.xtdplatform.core.action.Result;
import it.tasgroup.xtderp.xtdplatform.core.action.result.JsonResult;
import it.tasgroup.xtderp.xtdplatform.core.query.Query;
import it.tasgroup.xtderp.xtdplatform.core.query.QueryResult;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class JsonQueryAction extends QueryAction  {

    public JsonQueryAction(final Query query) {
        super(query);
    }

    @Override
    public String id() {
        return String.format("%s.json", this.query.id());
    }

    @Override
    Result wrap(final QueryResult result) {
        return new JsonResult(result);
    }
}