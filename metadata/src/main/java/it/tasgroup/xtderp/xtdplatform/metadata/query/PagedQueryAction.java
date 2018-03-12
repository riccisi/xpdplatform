package it.tasgroup.xtderp.xtdplatform.metadata.query;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Action;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;

public interface PagedQueryAction<T> extends Action<PagedCondition, Media> {

    String modelId();

    @Override
    QueryResult<T> execute(Request<PagedCondition> request) throws Exception;
}