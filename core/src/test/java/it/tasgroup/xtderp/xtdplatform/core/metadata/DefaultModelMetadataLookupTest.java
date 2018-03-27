package it.tasgroup.xtderp.xtdplatform.core.metadata;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class DefaultModelMetadataLookupTest {

    @Test
    public void testGetModel() throws Exception {
        assertThat(
            new DefaultMetadataLookup(
                new Metadata.Fake(
                    new ModelMetadata.Fake("a"), new ModelMetadata.Fake("b")
                )
            ).get("a"),
            equalTo(new ModelMetadata.Fake("a"))
        );
    }
}