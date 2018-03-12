package it.tasgroup.xtderp.xtdplatform.metadata.query;

import com.fasterxml.jackson.databind.JsonNode;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JsonConditionRequest implements Request<Condition> {

    private final Request<JsonNode> request;

    @Override
    public Condition value() {
        return new JsonFilters(this.request.value());
    }
}