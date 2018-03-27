package it.tasgroup.xtderp.xtdplatform.core.metadata;

import org.cactoos.list.ListOf;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Test case for {@link DefaultEntitiesMetadata}
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class DefaultEntitiesMetadataTest {

    @Test
    public void testIterator() {
        assertThat(
            new DefaultEntitiesMetadata(
                () -> new ListOf<>(new ModelMetadata.Fake(), new EntityMetadata.Fake()).iterator()
            ).iterator().next(),
            equalTo(new EntityMetadata.Fake())
        );
    }
}