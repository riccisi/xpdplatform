package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

import com.fasterxml.jackson.databind.node.BigIntegerNode;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.json.JsonMedia;
import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Test case for {@link PrintableBigInteger}
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class PrintableBigIntegerTest {

    @Test
    public void testPrint() throws Exception {
        assertThat(
            new PrintableBigInteger(BigInteger.valueOf(100L)).print(new JsonMedia()).value(),
            equalTo(new BigIntegerNode(BigInteger.valueOf(100L)))
        );
    }
}