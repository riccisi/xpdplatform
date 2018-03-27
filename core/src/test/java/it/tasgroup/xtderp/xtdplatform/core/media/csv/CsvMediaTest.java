package it.tasgroup.xtderp.xtdplatform.core.media.csv;

import org.cactoos.io.OutputStreamTo;
import org.junit.Test;

import java.io.StringWriter;

/**
 * Test case for {@link CsvMedia}
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class CsvMediaTest {

    @Test
    public void testAsObject() throws Exception {

        StringWriter writer = new StringWriter();
        CsvMedia media = new CsvMedia();
        media.asObject()
            .with("prop1","value1")
            .with("prop2","value2")
            .with("prop3",1)
            .with("prop4",1.1)
            .writeOn(new OutputStreamTo(writer));

        System.out.println(writer.toString());
    }
}