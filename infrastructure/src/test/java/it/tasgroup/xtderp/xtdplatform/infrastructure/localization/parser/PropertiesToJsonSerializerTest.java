package it.tasgroup.xtderp.xtdplatform.infrastructure.localization.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.*;

import java.util.Properties;

import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.junit.Assert.*;

public class PropertiesToJsonSerializerTest {

    @Test
    public void test() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        SimpleModule module = new SimpleModule();
        module.addSerializer(Properties.class, new PropertiesToJsonSerializer());
        mapper.registerModule(module);

        Properties properties = new Properties();
        properties.setProperty("a", "x");
        properties.setProperty("a.b", "y");
        properties.setProperty("a.b.c", "z");
        properties.setProperty("a.b.d", "w");

        String serialized = mapper.writeValueAsString(properties);

        assertThat(serialized, equalToIgnoringWhiteSpace("{ \"a\" : { \"b\" : { \"c\" : { \"text\" : \"z\" }, \"d\" : { \"text\" : \"w\" }, \"text\" : \"y\" }, \"text\" : \"x\" } }"));
    }
}