package it.tasgroup.xtderp.xtdplatform.metadata.query;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class JsonFilters implements Condition {

    private final JsonNode node;

    @Override
    public void apply(Statement statement) {
        List<Condition> conditions = new ArrayList<>();
        if (node.has("filters")) {
            JsonNode filterNodes = node.get("filters");
            for (JsonNode filterNode : filterNodes) {
                Condition childCondition = filterNode.has("filters") ?
                        new JsonFilters(filterNode) :
                        new JsonFilter(filterNode);
                conditions.add(childCondition);
            }
            switch (this.operator()) {
                case OR: statement.or(conditions); break;
                case AND: default: statement.and(conditions); break;
            }
        }
    }

    private LogicOperator operator() {
        return LogicOperator.valueOf(node.get("logicOperator").asText());
    }
}