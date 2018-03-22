package it.tasgroup.xtderp.xtdplatform.infrastructure.action.request;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;
import lombok.RequiredArgsConstructor;
import org.cactoos.Func;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class JsonRequest implements Request {

    private final Request request;
    private final ObjectMapper objectMapper;

    public JsonRequest(Request request) {
        this(request,  new ObjectMapper());
    }

    @Override
    public InputStream body() throws IOException {
        return this.request.body();
    }

    public <T> T parse(Func<JsonNode, T> func) throws Exception {
        JsonNode node = this.objectMapper.readTree(this.body());
        return func.apply(node);
    }

    public <T> T parse(Class<T> toParse) throws Exception{
        return this.parse(input -> objectMapper.treeToValue(input, toParse));
    }
}