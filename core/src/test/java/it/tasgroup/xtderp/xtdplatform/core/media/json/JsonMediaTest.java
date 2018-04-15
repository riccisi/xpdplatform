package it.tasgroup.xtderp.xtdplatform.core.media.json;

import org.junit.Test;

/**
 * Test case for {@link JsonMedia}
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class JsonMediaTest {

    @Test
    public void testAsObject() {
        Integer test = null;
        JsonMedia media = new JsonMedia();
        media.as(test);
    }
}