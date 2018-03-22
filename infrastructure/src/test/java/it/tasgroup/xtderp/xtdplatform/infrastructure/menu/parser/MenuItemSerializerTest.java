package it.tasgroup.xtderp.xtdplatform.infrastructure.menu.parser;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Action;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.MenuItem;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.MenuNodeVisitor;
import org.junit.Test;

import java.io.StringWriter;
import java.io.Writer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class MenuItemSerializerTest {

    @Test
    public void serialize() throws Exception {
        MenuItem menuItem = new MockMenuItem();
        Writer jsonWriter = new StringWriter();
        JsonGenerator jsonGenerator = new JsonFactory().createGenerator(jsonWriter);
        SerializerProvider serializerProvider = new ObjectMapper().getSerializerProvider();
        new MenuItemSerializer().serialize(menuItem, jsonGenerator, serializerProvider);
        jsonGenerator.flush();
        assertThat(jsonWriter.toString(), is(equalTo("{\"id\":\"test\",\"icon\":\"\",\"isFolder\":false,\"isLeaf\":true}")));
    }

    class MockMenuItem implements MenuItem {

        @Override
        public String code() {
            return "test";
        }

        @Override
        public void accept(MenuNodeVisitor visitor) {
            // do nothing
        }

        @Override
        public Action action() {
            return null;
        }
    }
}