package it.tasgroup.xtderp.xtdplatform.core.metadata;

import it.tasgroup.xtderp.xtdplatform.core.localization.I18n;
import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.RenderedObject;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class I18nAttribute implements Attribute {

    @NonNull private final Attribute attribute;
    @NonNull private final I18n i18n;
    @NonNull private final String prefix;

    @Override
    public String name() {
        return this.attribute.name();
    }

    @Override
    public <R, T> RenderedObject<R> printValue(final T model, final RenderedObject<R> rendered) {
        return this.attribute.printValue(model, rendered);
    }

    @Override
    public <R> RenderedObject<R> print(final Media<R> media) throws Exception {
        return this.attribute.print(media)
            .with("text", this.i18n.text(String.format("%s.%s",this.prefix,this.name())));
    }
}