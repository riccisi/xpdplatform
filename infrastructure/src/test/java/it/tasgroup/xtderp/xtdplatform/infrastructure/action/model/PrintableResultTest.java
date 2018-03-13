package it.tasgroup.xtderp.xtdplatform.infrastructure.action.model;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.result.PrintableResult;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Printable;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.json.JsonMedia;
import org.cactoos.io.OutputStreamTo;
import org.junit.Test;

import java.io.StringWriter;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

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

        PrintableResult result = new PrintableResult(new Printable() {
            @Override
            public <T> Rendered<T> print(Media<T> media) {
                return media.object().with("prop", "value");
            }
        }, new JsonMedia());

        StringWriter writer = new StringWriter();
        result.writeOn(new OutputStreamTo(writer));
        assertThat(writer.toString(), equalTo("{\"prop\":\"value\"}"));
    }
}