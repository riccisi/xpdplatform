package it.tasgroup.xtderp.xtdplatform.metadata.model;

import org.junit.*;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class CachedModelLookupTest {

    @Test
    public void get() {

        ModelLookup alwaysNew = MockModel::new;

        Model a = alwaysNew.get("a");
        Model aBis = alwaysNew.get("a");

        assertThat("same key subsequent calls", a, not(equalTo(aBis)));

        CachedModelLookup lookup = new CachedModelLookup(alwaysNew);

        Model b = lookup.get("b");
        Model bBis = lookup.get("b");
        Model c = lookup.get("c");

        assertThat("same key subsequent calls", b, equalTo(bBis));
        assertThat("different key", b, not(equalTo(c)));
    }
}