package it.tasgroup.xtderp.xtdplatform.core.menu.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import it.tasgroup.xtderp.xtdplatform.core.menu.model.MenuFolder;
import it.tasgroup.xtderp.xtdplatform.core.menu.model.MenuItem;
import it.tasgroup.xtderp.xtdplatform.core.menu.model.MenuNode;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MenuNodeDeserializerTest {

    private ObjectMapper mapper;

    @Before
    public void setUp() {
        mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(MenuNode.class, new MenuNodeDeserializer());
        mapper.registerModule(module);
    }

    @Test
    public void deserialize() throws IOException {
        String json = "{\"id\":\"parent\",\"icon\":\"\",\"isFolder\":true,\"isLeaf\":false,\"children\":[{\"id\":\"child\",\"icon\":\"\",\"isFolder\":false,\"isLeaf\":true}]}";
        MenuNode menuNode = mapper.readValue(json, MenuNode.class);
        assertEquals("parent", menuNode.code());
        assertTrue(MenuFolder.class.isAssignableFrom(menuNode.getClass()));

        for (MenuNode child : ((MenuFolder) menuNode)) {
            assertEquals("child", child.code());
            assertTrue(MenuItem.class.isAssignableFrom(child.getClass()));
        }
    }
}