package it.tasgroup.xtderp.xtdplatform.infrastructure.action.request;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.InputStream;

/**
 * {@link Request} decorator converting an {@link InputStream} to a {@link JsonNode}
 */
@RequiredArgsConstructor
public class StreamToJsonRequest implements Request<JsonNode> {

    private final Request<InputStream> request;

    private final ObjectMapper objectMapper;

    @Override
    public JsonNode value() throws Exception {
        return this.objectMapper.readTree(this.request.value());
    }
}
