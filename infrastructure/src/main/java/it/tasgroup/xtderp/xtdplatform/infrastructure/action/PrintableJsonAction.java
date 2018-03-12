package it.tasgroup.xtderp.xtdplatform.infrastructure.action;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.request.HttpJsonRequest;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.result.HttpJsonResult;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action decorator handling incoming stream requests and result is JSON format.
 */
@RequiredArgsConstructor
public class PrintableJsonAction implements Action<HttpServletRequest,HttpServletResponse> {

    private final ObjectMapper mapper;

    @Override
    public String id() {
        return String.format("%s.json", this.delegate.id());
    }

    @Override
    public Result<HttpServletResponse> execute(Request<HttpServletRequest> request) throws Exception {


        this.delegate.execute(new HttpJsonRequest(request, mapper));


        return new HttpJsonResult( );
    }

    @Override
    public <T> Rendered<T> print(Media<T> media) {
        return media.object()
                .with("id", this.id())
                .with("accept", "json")
                .with("return", "json");
    }
}