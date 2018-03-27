package it.tasgroup.xtderp.xtdplatform.core.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

@RequiredArgsConstructor
public class JsonSerializerTester<T> {

    private final JsonSerializer<T> jsonSerializer;

    public String test(T serializable) throws IOException {
        Writer jsonWriter = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        JsonGenerator generator = new JsonFactory().createGenerator(jsonWriter);
        generator.setCodec(mapper);
        SerializerProvider provider = mapper.getSerializerProvider();
        this.jsonSerializer.serialize(serializable, generator, provider);
        generator.flush();
        return jsonWriter.toString();
    }

}