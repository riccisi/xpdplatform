package it.tasgroup.xtderp.xtdplatform.core.query.filter.json;

import com.fasterxml.jackson.databind.node.*;
import it.tasgroup.xtderp.xtdplatform.core.util.DefaultDateAsString;
import it.tasgroup.xtderp.xtdplatform.core.util.StringAsDate;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Test case for {@link ValueOf}
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class ValueOfTest {

    @Test
    public void testShort() {
        assertThat(
            new ValueOf(new ShortNode((short) 100)).get(),
            equalTo(((short) 100))
        );
    }

    @Test
    public void testInt() {
        assertThat(
            new ValueOf(new IntNode(1)).get(),
            equalTo(1)
        );
    }

    @Test
    public void testLong() {
        assertThat(
            new ValueOf(new LongNode(10000L)).get(),
            equalTo(10000L)
        );
    }

    @Test
    public void testDouble() {
        assertThat(
            new ValueOf(new DoubleNode(1000.5)).get(),
            equalTo(1000.5)
        );
    }

    @Test
    public void testBoolean() {
        assertThat(
            new ValueOf(BooleanNode.valueOf(true)).get(),
            equalTo(true)
        );
    }

    @Test
    public void testBooleanAsString() {
        assertThat(
            new ValueOf(new TextNode("false")).get(),
            equalTo(false)
        );
    }

    @Test
    public void testString() {
        assertThat(
            new ValueOf(new TextNode("test")).get(),
            equalTo("test")
        );
    }

    @Test
    public void testBigDecimal() {
        assertThat(
            new ValueOf(new DecimalNode(new BigDecimal(100.2))).get(),
            equalTo(new BigDecimal(100.2))
        );
    }

    @Test
    public void testArray() {
        assertThat(
            new ValueOf(new ArrayNode(JsonNodeFactory.instance, Arrays.asList(new TextNode("test1"),new TextNode("test2")))).get(),
            equalTo(Arrays.asList("test1", "test2"))
        );
    }

    @Test
    public void testDate() throws Exception {
        assertThat(
            new ValueOf(new TextNode(new DefaultDateAsString(new StringAsDate("dd/MM/yyyy","21/03/2018").value()).value())).get(),
            equalTo(new StringAsDate("dd/MM/yyyy","21/03/2018").value())
        );
    }
}