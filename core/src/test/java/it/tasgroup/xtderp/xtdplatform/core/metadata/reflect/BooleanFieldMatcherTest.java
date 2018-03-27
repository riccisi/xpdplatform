package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test case for {@link BigDecimalField.Matcher}
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class BooleanFieldMatcherTest {

    private Boolean right;
    private Double wrong;

    @Test
    public void match() throws Exception {
        assertTrue(
            new BooleanField.Matcher(BooleanFieldMatcherTest.class.getDeclaredField("right")).match()
        );
    }

    @Test
    public void unMatch() throws Exception {
        assertFalse(
            new BooleanField.Matcher(BooleanFieldMatcherTest.class.getDeclaredField("wrong")).match()
        );
    }
}