package it.tasgroup.xtderp.xtdplatform.infrastructure.action.model;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Action;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.ActionLookup;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.ActionNotFoundException;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.DefaultActionLookup;
import org.cactoos.list.ListOf;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

/**
 * Test case for {@link DefaultActionLookup}
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class DefaultActionLookupTest {

    private ActionLookup lookup;

    @Before
    public void init() {
        this.lookup = new DefaultActionLookup(() -> new ListOf<>(Action.EMPTY).iterator());
    }

    @Test
    public void okForGoodId() throws Exception {
        assertThat(this.lookup.get("empty"), notNullValue());
    }

    @Test(expected = ActionNotFoundException.class)
    public void failForWrongId() throws Exception {
        this.lookup.get("wrong");
    }
}