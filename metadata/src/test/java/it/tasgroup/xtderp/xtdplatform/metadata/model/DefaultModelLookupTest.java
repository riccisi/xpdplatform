package it.tasgroup.xtderp.xtdplatform.metadata.model;

import org.junit.*;

import java.util.Arrays;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class DefaultModelLookupTest {

    @Test
    public void testGetModel() {

        MockModel a = new MockModel("a");
        MockModel b = new MockModel("b");
        MockModel c = new MockModel("c");

        Models models = () -> Arrays.<Model>asList(a, b, c).iterator();

        DefaultModelLookup modelLookup = new DefaultModelLookup(models);
        Model found = modelLookup.get("b");

        assertThat("found model", found, equalTo(b));

        try {
            modelLookup.get("e");
            fail();
        } catch (IllegalArgumentException e) {
        }
    }
}