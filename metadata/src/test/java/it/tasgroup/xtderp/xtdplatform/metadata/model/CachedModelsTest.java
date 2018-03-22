package it.tasgroup.xtderp.xtdplatform.metadata.model;

import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class CachedModelsTest {

    @Test
    public void test() {

        Models models = () -> Collections.<ModelMetadata>singletonList(new MockModelMetadata("a")).iterator();

        assertThat("subsequent calls are different", models.iterator().next(), not(equalTo(models.iterator().next())));

        CachedModels cachedModels = new CachedModels(models);

        assertThat("subsequent calls are equals", cachedModels.iterator().next(), equalTo(cachedModels.iterator().next()));

    }
}