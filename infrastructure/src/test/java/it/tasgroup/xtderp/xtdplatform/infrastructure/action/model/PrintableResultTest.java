package it.tasgroup.xtderp.xtdplatform.infrastructure.action.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.result.PrintableResult;
import org.cactoos.io.OutputStreamTo;
import org.junit.Test;

import java.io.StringWriter;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class PrintableResultTest {

    /**
     * ${CLASS} can work.
     *
     * @throws Exception If fails
     */
    @Test
    public void testPrint() throws Exception {

        PrintableResult result = new PrintableResult(media -> {
            media.with("prop", "value");
        }, new ObjectMapper());

        StringWriter writer = new StringWriter();
        result.printOn(new OutputStreamTo(writer));
        assertThat(writer.toString(), equalTo("{\"prop\":\"value\"}"));
    }
}