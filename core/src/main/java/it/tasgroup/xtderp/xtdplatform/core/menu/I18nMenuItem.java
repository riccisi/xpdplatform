package it.tasgroup.xtderp.xtdplatform.core.menu;

import it.tasgroup.xtderp.xtdplatform.core.localization.I18n;
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
public final class I18nMenuItem implements MenuItem {

    private final MenuItem delegate;
    private final I18n i18n;

    @Override
    public String path() {
        return this.delegate.path();
    }

    @Override
    public <R> RenderedObject<R> print(final Media<R> media) throws Exception {
        return this.delegate.print(media).with("text", this.i18n.text(this.path()));
    }
}
