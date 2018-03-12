package it.tasgroup.xtderp.xtdplatform.infrastructure.action.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.request.StreamToJsonRequest;
import org.cactoos.io.InputStreamOf;
import org.cactoos.text.TextOf;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class StreamToJsonRequestTest {

    @Test
    public void value() {
        StreamToJsonRequest request = new StreamToJsonRequest(
            () -> new InputStreamOf(new TextOf("{ \"prop\": \"value\"}")), new ObjectMapper()
        );

        JsonNode jsonNode = request.value();
        assertThat(jsonNode, notNullValue());
        assertThat(jsonNode.isObject(), is(true));
        assertThat(jsonNode.get("prop").asText(), is("value"));
    }
}