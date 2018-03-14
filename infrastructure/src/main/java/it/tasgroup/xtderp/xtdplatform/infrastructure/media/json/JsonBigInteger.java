package it.tasgroup.xtderp.xtdplatform.infrastructure.media.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;

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
final class JsonBigInteger extends JsonRendered implements Rendered<JsonNode> {

    private final BigInteger value;

    @Override
    public JsonNode value() {
        return new BigIntegerNode(this.value);
    }
}
