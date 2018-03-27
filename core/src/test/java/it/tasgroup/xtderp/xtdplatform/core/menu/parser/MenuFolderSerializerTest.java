package it.tasgroup.xtderp.xtdplatform.core.menu.parser;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import it.tasgroup.xtderp.xtdplatform.core.menu.model.MenuFolder;
import it.tasgroup.xtderp.xtdplatform.core.menu.model.MenuNode;
import it.tasgroup.xtderp.xtdplatform.core.menu.model.MenuNodeVisitor;
import org.junit.Test;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class MenuFolderSerializerTest {

    @Test
    public void serialize() throws Exception {
        MenuFolder menuFolder = new MockMenuFolder();
        Writer jsonWriter = new StringWriter();
        JsonGenerator jsonGenerator = new JsonFactory().createGenerator(jsonWriter);
        SerializerProvider serializerProvider = new ObjectMapper().getSerializerProvider();
        new MenuFolderSerializer().serialize(menuFolder, jsonGenerator, serializerProvider);
        jsonGenerator.flush();
        assertThat(jsonWriter.toString(), is(equalTo("{\"id\":\"test\",\"icon\":\"\",\"isFolder\":true,\"isLeaf\":false,\"children\":null}")));
    }

    class MockMenuFolder implements MenuFolder {

        @Override
        public String code() {
            return "test";
        }

        @Override
        public void accept(MenuNodeVisitor visitor) {
            // do nothing
        }

        @Override
        public Iterator<MenuNode> iterator() {
            return null;
        }
    }
}