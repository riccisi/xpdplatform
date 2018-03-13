package it.tasgroup.xtderp.xtdplatform.metadata.query;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Action;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Result;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.request.HttpJsonRequest;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.result.HttpJsonResult;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Printable;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 */
@RequiredArgsConstructor
public class JsonQueryAction implements Action<HttpServletRequest,HttpServletResponse> {

    private final Query query;

    @Override
    public String id() {
        return String.format("%s.json", this.query.id());
    }

    @Override
    public Result<HttpServletResponse> execute(Request<HttpServletRequest> request) throws Exception {
        Condition condition = new JsonFilters(new HttpJsonRequest(request).value());
        return new HttpJsonResult(this.query.find(condition));
    }

    @Override
    public Rendered print(Media media) {
        return media.object()
            .with("id", this.id())
            .with("type", "query")
            .with("modelId", this.query.modelId());
    }

}