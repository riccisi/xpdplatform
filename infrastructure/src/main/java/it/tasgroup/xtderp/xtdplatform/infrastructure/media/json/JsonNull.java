package it.tasgroup.xtderp.xtdplatform.infrastructure.media.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
final class JsonNull extends JsonRendered implements Rendered<JsonNode> {

    @Override
    public JsonNode value() {
        return NullNode.getInstance();
    }
}
