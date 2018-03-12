package it.tasgroup.xtderp.xtdplatform.metadata.model;

import org.junit.*;

public class CachedModelTest {

    @Test
    public void test() {

        CachedModel cachedModel = new CachedModel(new MockModel("test"));
    }
}