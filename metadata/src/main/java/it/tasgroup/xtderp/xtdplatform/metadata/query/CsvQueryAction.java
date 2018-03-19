package it.tasgroup.xtderp.xtdplatform.metadata.query;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Action;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Result;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.request.HttpJsonRequest;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.result.HttpCsvResult;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class CsvQueryAction implements Action<HttpServletRequest,HttpServletResponse> {

    private final Query query;

    @Override
    public String id() {
        return String.format("%s.csv", this.query.id());
    }

    @Override
    public Result<HttpServletResponse> execute(Request<HttpServletRequest> request) throws Exception {
        Condition condition = new JsonFilters(new HttpJsonRequest(request).value());
        return new HttpCsvResult(this.query.find(condition));
    }

    @Override
    public <T> Rendered<T> print(Media<T> media) {
        return media.asObject()
            .with("id", this.id())
            .with("type", "query")
            .with("modelId", this.query.modelId());
    }
}