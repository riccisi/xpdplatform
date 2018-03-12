package it.tasgroup.xtderp.xtdplatform.metadata.model;

import org.junit.*;

import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class ConfigurableModelsTest {

    @Test
    public void test() {

        MockModel a = new MockModel("a");
        MockModel b = new MockModel("b");
        MockModel c = new MockModel("c");

        ModelConfigurer configurer1 = register -> {
            register.add(a);
            register.add(b);
        };

        ModelConfigurer configurer2 = register -> {
            register.add(c);
        };

        ConfigurableModels models = new ConfigurableModels(Arrays.asList(configurer1, configurer2));

        Iterator<Model> it = models.iterator();
        assertThat("found model a", it.next(), equalTo(a));
        assertThat("found model b", it.next(), equalTo(b));
        assertThat("found model c", it.next(), equalTo(c));
    }
}