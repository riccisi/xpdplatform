package it.tasgroup.xtderp.xtdplatform.core.media;

import it.tasgroup.xtderp.xtdplatform.core.media.json.JsonMedia;
import it.tasgroup.xtderp.xtdplatform.core.util.DefaultDateAsString;
import org.cactoos.io.OutputStreamTo;
import org.junit.Test;

import java.io.StringWriter;
import java.util.Date;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Test case for {@link PrintableDate}
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class PrintableDateTest {

    @Test
    public void testPrint() throws Exception {
        Date date = new Date();
        StringWriter writer = new StringWriter();
        new PrintableDate(date).print(new JsonMedia()).writeOn(new OutputStreamTo(writer));
        assertThat(writer.toString(), equalTo("\""+new DefaultDateAsString(date).value()+"\""));
    }
}