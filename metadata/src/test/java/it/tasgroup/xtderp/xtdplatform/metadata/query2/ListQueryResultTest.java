package it.tasgroup.xtderp.xtdplatform.metadata.query2;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.result.PrintableResult;
import it.tasgroup.xtderp.xtdplatform.metadata.query.ListQueryResult;
import org.cactoos.io.OutputStreamTo;
import org.junit.Test;

import java.io.StringWriter;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class ListQueryResultTest {

    /**
     * ${CLASS} can work.
     *
     * @throws Exception If fails
     */
    @Test
    public void testPrint() throws Exception {
        PrintableResult result = new PrintableResult(new ListQueryResult<>(Arrays.asList("a","b","c")), new ObjectMapper());
        StringWriter writer = new StringWriter();
        result.printOn(new OutputStreamTo(writer));
        assertThat(writer.toString(), equalTo("{\"result\":[\"a\",\"b\",\"c\"]}"));
    }
}