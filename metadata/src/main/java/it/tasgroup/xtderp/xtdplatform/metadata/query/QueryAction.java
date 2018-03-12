package it.tasgroup.xtderp.xtdplatform.metadata.query;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Action;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;

public interface QueryAction<T> extends Action<Condition, Media> {

    String modelId();

    QueryResult<T> execute(Request<Condition> request) throws Exception;
}
