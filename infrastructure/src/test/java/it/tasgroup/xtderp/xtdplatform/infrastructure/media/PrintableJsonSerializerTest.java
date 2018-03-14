package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.json.PrintableJsonSerializer;
import it.tasgroup.xtderp.xtdplatform.infrastructure.util.JsonSerializerTester;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class PrintableJsonSerializerTest {

    private JsonSerializerTester<Printable> tester = new JsonSerializerTester<>(new PrintableJsonSerializer());

    @Test
    public void serialize() throws IOException, ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2018-02-16");
        Printable printable = new Printable() {
            @Override
            public <T> Rendered<T> print(Media<T> media) {
                return media.asObject()
                    .with("prop1", "val1")
                    .with("prop2", 1)
                    .with("prop3", 1L)
                    .with("prop4", 1.2)
                    .with("prop5", true)
                    .with("prop6", date)
                    .with("prop7", "1","2");
            }
        };

        assertThat(tester.test(printable), is(equalTo("{\"prop1\":\"val1\",\"prop2\":1,\"prop3\":1,\"prop4\":1.2,\"prop5\":true,\"prop6\":\"2018-02-16T00:00:00.000+0100\",\"prop7\":[\"1\",\"2\"]}")));
    }
}