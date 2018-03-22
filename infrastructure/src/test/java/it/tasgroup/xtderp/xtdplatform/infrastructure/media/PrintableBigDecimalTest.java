package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

import com.fasterxml.jackson.databind.node.DecimalNode;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.json.JsonMedia;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Test case for {@link PrintableBigDecimal}
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class PrintableBigDecimalTest {

    @Test
    public void testPrint() throws Exception {
        assertThat(
            new PrintableBigDecimal(new BigDecimal(10.0)).print(new JsonMedia()).value(),
            equalTo(new DecimalNode(new BigDecimal(10.0)))
        );
    }
}