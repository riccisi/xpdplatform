package it.tasgroup.xtderp.xtdplatform.core.metadata;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import lombok.RequiredArgsConstructor;

/**
 * {@link Model} decorator that 'process' the model using the provided {@link ProcessStrategy}.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class ProcessedModel<T> implements Model<T> {

    private final Model<T> model;
    private final ProcessStrategy<T> strategy;

    @Override
    public T value() {
        try {
            return this.strategy.apply(this.model).value();
        } catch (final ModelProcessException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public <R> Rendered<R> print(final Media<R> media) throws Exception {
        return this.strategy.apply(this.model).print(media);
    }
}