package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Test case for {@link BigDecimalField.Matcher}
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class BigDecimalFieldMatcherTest {

    private BigDecimal right;
    private Double wrong;

    @Test
    public void match() throws Exception {
        assertTrue(
            new BigDecimalField.Matcher(BigDecimalFieldMatcherTest.class.getDeclaredField("right")).match()
        );
    }

    @Test
    public void unMatch() throws Exception {
        assertFalse(
            new BigDecimalField.Matcher(BigDecimalFieldMatcherTest.class.getDeclaredField("wrong")).match()
        );
    }
}