package it.tasgroup.xtderp.xtdplatform.core.metadata;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsSame.theInstance;
import static org.junit.Assert.assertThat;

public class CachedModelMetadataLookupTest {

    @Test
    public void get() {
        CachedMetadataLookup lookup = new CachedMetadataLookup(new MetadataLookup.Fake());
        ModelMetadata metadata = lookup.get("test");
        assertThat(
            lookup.get("test"),
            theInstance(metadata)
        );
    }
}