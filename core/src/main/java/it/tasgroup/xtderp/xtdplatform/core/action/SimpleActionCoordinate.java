package it.tasgroup.xtderp.xtdplatform.core.action;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.RenderedObject;
import it.tasgroup.xtderp.xtdplatform.core.menu.MenuAction;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class SimpleActionCoordinate implements ActionCoordinate {

    private final String actionId;
    private final String uid;
    private final Map<String, String> params;

    public SimpleActionCoordinate(final MenuAction action) {
        this(action.id(), action.uid(), new HashMap<>());
    }

    @Override
    public <R> RenderedObject<R> print(final Media<R> media) {
        RenderedObject<R> rendered = media.asObject().with("actionId", this.actionId).with("uid", this.uid);
        for (final Map.Entry<String, String> entry : this.params.entrySet()) {
            rendered = rendered.with(entry.getKey(), entry.getValue());
        }
        return rendered;
    }
}
