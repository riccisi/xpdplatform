package it.tasgroup.xtderp.xtdplatform.core.media.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
@EqualsAndHashCode(of = "value", callSuper = false)
@ToString(of = "value")
final class JsonString extends JsonRendered {

    private final String value;

    @Override
    public JsonNode value() {
        return new TextNode(this.value);
    }
}