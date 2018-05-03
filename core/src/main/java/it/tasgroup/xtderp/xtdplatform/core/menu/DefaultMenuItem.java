package it.tasgroup.xtderp.xtdplatform.core.menu;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.RenderedObject;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class DefaultMenuItem implements MenuItem {

    private final MenuNode node;

    @Override
    public String path() {
        return this.node.path();
    }

    @Override
    public <R> RenderedObject<R> print(final Media<R> media) {
        return media.asObject().with("id", this.node.path());
    }
}
