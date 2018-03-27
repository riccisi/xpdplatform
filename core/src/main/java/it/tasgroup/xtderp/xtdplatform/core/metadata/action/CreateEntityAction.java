package it.tasgroup.xtderp.xtdplatform.core.metadata.action;

import it.tasgroup.xtderp.xtdplatform.core.action.Action;
import it.tasgroup.xtderp.xtdplatform.core.action.Request;
import it.tasgroup.xtderp.xtdplatform.core.action.Result;
import it.tasgroup.xtderp.xtdplatform.core.action.result.JsonResult;
import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.core.metadata.EntityMetadata;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class CreateEntityAction implements Action {

    @NonNull private final EntityMetadata metadata;

    @Override
    public String id() throws Exception {
        return String.format("create%s.json", this.metadata.id());
    }

    @Override
    public Result execute(Request request) throws Exception {
        return new JsonResult(this.metadata.newInstance());
    }

    @Override
    public <R> Rendered<R> print(Media<R> media) throws Exception {
        return media.asObject()
            .with("id", this.id())
            .with("type", "entity")
            .with("modelId", this.metadata.id());
    }
}