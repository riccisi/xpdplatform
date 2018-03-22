package it.tasgroup.xtderp.xtdplatform.metadata.model;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class CachedModelMetadataLookupTest {

    @Test
    public void get() {

        ModelLookup alwaysNew = MockModelMetadata::new;

        ModelMetadata a = alwaysNew.get("a");
        ModelMetadata aBis = alwaysNew.get("a");

        assertThat("same key subsequent calls", a, not(equalTo(aBis)));

        CachedModelLookup lookup = new CachedModelLookup(alwaysNew);

        ModelMetadata b = lookup.get("b");
        ModelMetadata bBis = lookup.get("b");
        ModelMetadata c = lookup.get("c");

        assertThat("same key subsequent calls", b, equalTo(bBis));
        assertThat("different key", b, not(equalTo(c)));
    }
}