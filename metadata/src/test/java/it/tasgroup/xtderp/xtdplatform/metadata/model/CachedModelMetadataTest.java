package it.tasgroup.xtderp.xtdplatform.metadata.model;

import org.junit.Test;

public class CachedModelMetadataTest {

    @Test
    public void test() {

        CachedModelMetadata cachedModel = new CachedModelMetadata(new MockModelMetadata("test"));
    }
}