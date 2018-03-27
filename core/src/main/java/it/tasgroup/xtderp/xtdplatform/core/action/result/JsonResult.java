package it.tasgroup.xtderp.xtdplatform.core.action.result;

import it.tasgroup.xtderp.xtdplatform.core.action.Output;
import it.tasgroup.xtderp.xtdplatform.core.action.Result;
import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.json.JsonMedia;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class JsonResult implements Result {

    private static final String JSON_CONTENT_TYPE = "application/json;charset=UTF-8";

    private final Printable printable;

    @Override
    public void writeOn(Output output) throws Exception {
        output.ofType(JSON_CONTENT_TYPE);
        this.printable.print(new JsonMedia()).writeOn(output.stream());
    }
}