package it.tasgroup.xtderp.xtdplatform.core.action.model;

import it.tasgroup.xtderp.xtdplatform.core.action.Action;
import it.tasgroup.xtderp.xtdplatform.core.action.Actions;
import it.tasgroup.xtderp.xtdplatform.core.action.DefaultActionLookup;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Test case for {@link DefaultActionLookup}
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class DefaultActionLookupTest {

    @Test
    public void testRightGetWithGoodId() throws Exception {
        assertThat(
            new DefaultActionLookup(new Actions.Fake(new Action.Fake("test"))).get("test"),
            equalTo(new Action.Fake("test"))
        );
    }

    @Test(expected = IOException.class)
    public void failForWrongId() throws Exception {
        new DefaultActionLookup(new Actions.Fake()).get("test");
    }
}