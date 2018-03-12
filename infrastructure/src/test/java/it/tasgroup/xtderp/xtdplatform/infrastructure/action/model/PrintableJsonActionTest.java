package it.tasgroup.xtderp.xtdplatform.infrastructure.action.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.*;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.request.HttpToStreamRequest;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import org.cactoos.io.InputStreamOf;
import org.cactoos.text.TextOf;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class PrintableJsonActionTest {

    @Test
    public void execute() {
        PrintableJsonAction action = new PrintableJsonAction(new Action<JsonNode,Media>() {
            @Override
            public void print(Media media) {
                throw new UnsupportedOperationException("#print()");
            }

            @Override
            public Result<Media> execute(Request<JsonNode> request) throws Exception {
                JsonNode node = request.value();
                assertThat(node, notNullValue());
                assertThat(node.isObject(), is(true));
                assertThat(node.get("prop").asText(), is("value"));
                return Result.EMPTY;
            }

            @Override
            public String id() {
                return "test";
            }
        }, new ObjectMapper());
        try {
            action.execute(new HttpToStreamRequest(new InputStreamOf(new TextOf("{ \"prop\": \"value\"}"))));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}