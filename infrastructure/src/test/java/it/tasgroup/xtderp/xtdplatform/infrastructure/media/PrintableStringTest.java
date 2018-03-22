package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.json.JsonMedia;
import org.cactoos.io.OutputStreamTo;
import org.junit.Test;

import java.io.StringWriter;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Test case for {@link PrintableString}
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class PrintableStringTest {

    @Test
    public void testPrint() throws Exception {
        StringWriter writer = new StringWriter();
        new PrintableString("test").print(new JsonMedia()).writeOn(new OutputStreamTo(writer));
        assertThat(writer.toString(), equalTo("\"test\""));
    }
}