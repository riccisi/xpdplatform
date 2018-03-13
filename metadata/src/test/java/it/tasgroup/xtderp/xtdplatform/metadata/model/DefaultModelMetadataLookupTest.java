package it.tasgroup.xtderp.xtdplatform.metadata.model;

import org.junit.*;

import java.util.Arrays;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class DefaultModelMetadataLookupTest {

    @Test
    public void testGetModel() {

        MockModelMetadata a = new MockModelMetadata("a");
        MockModelMetadata b = new MockModelMetadata("b");
        MockModelMetadata c = new MockModelMetadata("c");

        Models models = () -> Arrays.<ModelMetadata>asList(a, b, c).iterator();

        DefaultModelLookup modelLookup = new DefaultModelLookup(models);
        ModelMetadata found = modelLookup.get("b");

        assertThat("found model", found, equalTo(b));

        try {
            modelLookup.get("e");
            fail();
        } catch (IllegalArgumentException e) {
        }
    }
}