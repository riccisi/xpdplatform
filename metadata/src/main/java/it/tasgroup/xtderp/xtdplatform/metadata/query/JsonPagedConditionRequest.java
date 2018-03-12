package it.tasgroup.xtderp.xtdplatform.metadata.query;

import com.fasterxml.jackson.databind.JsonNode;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JsonPagedConditionRequest implements Request<PagedCondition> {

    private final Request<JsonNode> request;

    @Override
    public PagedCondition value() {
        return new JsonPagedCondition(request.value());
    }
}