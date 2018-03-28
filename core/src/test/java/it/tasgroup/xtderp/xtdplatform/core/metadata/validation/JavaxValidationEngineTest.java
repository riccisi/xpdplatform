package it.tasgroup.xtderp.xtdplatform.core.metadata.validation;

import it.tasgroup.xtderp.xtdplatform.core.media.json.JsonMedia;
import lombok.RequiredArgsConstructor;
import org.cactoos.io.OutputStreamTo;
import org.hibernate.validator.constraints.NotBlank;
import org.junit.Test;

import java.io.StringWriter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Test case for {@link JavaxValidationEngine}
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
public final class JavaxValidationEngineTest {

    @Test
    public void testValid() {
        assertThat(
            new JavaxValidationEngine<>(new Fake(null)).result().valid(),
            is(false)
        );
    }

    @Test
    public void testPrint() throws Exception {
        final StringWriter writer = new StringWriter();
        new JavaxValidationEngine<>(new Fake(null)).result().print(new JsonMedia()).writeOn(new OutputStreamTo(writer));
        assertThat(
            writer.toString(),
            equalTo("{\"valid\":false,\"mandatory\":[\"may not be empty\"]}")
        );
    }

    @RequiredArgsConstructor
    private static class Fake {
        @NotBlank
        private final String mandatory;
    }

}