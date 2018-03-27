package it.tasgroup.xtderp.xtdplatform.core.query.filter.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Test case for {@link JsonEq.Matcher}
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class JsonEqMatcherTest {

    @Test
    public void firstPositiveMatch() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.set("operator", new TextNode("eq"));
        assertTrue(new JsonEq.Matcher(node).match());
    }

    @Test
    public void secondPositiveMatch() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.set("operator", new TextNode("="));
        assertTrue(new JsonEq.Matcher(node).match());
    }

    @Test
    public void thirdPositiveMatch() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.set("operator", new TextNode("=="));
        assertTrue(new JsonEq.Matcher(node).match());
    }

    @Test
    public void fourthPositiveMatch() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.set("operator", new TextNode("==="));
        assertTrue(new JsonEq.Matcher(node).match());
    }

    @Test
    public void fifthPositiveMatch() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.set("exactMatch", BooleanNode.valueOf(true));
        assertTrue(new JsonEq.Matcher(node).match());
    }

    @Test
    public void negativeMatch() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.set("operator", new TextNode("like"));
        assertFalse(new JsonEq.Matcher(node).match());
    }
}