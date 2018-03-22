package it.tasgroup.xtderp.xtdplatform.infrastructure.action.model;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Action;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.ActionNotFoundException;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Actions;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.DefaultActionLookup;
import org.junit.Test;

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

    @Test(expected = ActionNotFoundException.class)
    public void failForWrongId() throws Exception {
        new DefaultActionLookup(new Actions.Fake()).get("test");
    }
}