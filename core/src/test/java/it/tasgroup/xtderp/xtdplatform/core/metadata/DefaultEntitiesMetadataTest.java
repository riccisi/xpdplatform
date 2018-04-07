package it.tasgroup.xtderp.xtdplatform.core.metadata;

import org.cactoos.list.ListOf;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Test case for {@link DefaultEntitiesMetadata}
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class DefaultEntitiesMetadataTest {

    @SuppressWarnings("unchecked")
    @Test
    public final void testIterator() {
        assertThat(
            new DefaultEntitiesMetadata(
                () -> new ListOf(new ModelMetadata.Fake(), new EntityMetadata.Fake()).iterator()
            ).iterator().next(),
            equalTo(new EntityMetadata.Fake())
        );
    }
}