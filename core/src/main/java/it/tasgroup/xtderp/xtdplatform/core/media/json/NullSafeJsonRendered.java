package it.tasgroup.xtderp.xtdplatform.core.media.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
final class NullSafeJsonRendered extends JsonRendered {

    private final Object value;
    private final Rendered<JsonNode> rendered;

    @Override
    @SuppressWarnings("VariableNotUsedInsideIf")
    public JsonNode value() throws Exception {
        return this.value != null ? this.rendered.value() : NullNode.getInstance();
    }
}