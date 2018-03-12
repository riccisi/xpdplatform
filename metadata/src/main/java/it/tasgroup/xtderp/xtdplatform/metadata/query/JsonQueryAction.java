package it.tasgroup.xtderp.xtdplatform.metadata.query;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.ActionWrapper;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action stack adapting incoming HTTP JSON request to <code>QueryAction</code> execution.
 *
 */
public class JsonQueryAction<T> extends ActionWrapper<HttpServletRequest,HttpServletResponse> {

    public JsonQueryAction(QueryAction<T> queryAction, ObjectMapper mapper) {
        super(
            new HttpJsonAction(
                new JsonRequestDecorator<Condition>(queryAction) {

                    @Override
                    protected Request<Condition> decorate(Request<JsonNode> request) {
                        return new JsonConditionRequest(request);
                    }
                },
                mapper
            )
        );
    }

    public JsonQueryAction(PagedQueryAction<T> queryAction, ObjectMapper mapper) {
        super(
            new HttpJsonAction(
                new JsonRequestDecorator<PagedCondition>(queryAction) {

                    @Override
                    protected Request<PagedCondition> decorate(Request<JsonNode> request) {
                        return new JsonPagedConditionRequest(request);
                    }
                },
                mapper
            )
        );
    }
}

