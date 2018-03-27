package it.tasgroup.xtderp.xtdplatform.core.metadata;

import org.cactoos.iterable.IterableOf;
import org.cactoos.iterable.LengthOf;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ConfigurableMetadataTest {

    @Test
    public void test() {
        assertThat(
            new LengthOf(
                new ConfigurableMetadata(
                    new IterableOf<>(
                        register -> {
                            register.add(new ModelMetadata.Fake("a"));
                            register.add(new ModelMetadata.Fake("b"));
                        },
                        register -> {
                            register.add(new ModelMetadata.Fake("c"));
                        }
                    )
                )
            ).intValue(),
            equalTo(3)
        );
    }
}