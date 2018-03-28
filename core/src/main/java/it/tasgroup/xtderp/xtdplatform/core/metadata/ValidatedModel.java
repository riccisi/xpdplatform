package it.tasgroup.xtderp.xtdplatform.core.metadata;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import lombok.RequiredArgsConstructor;

/**
 * {@link Model} decorator that add validation info using the provided {@link ValidationEngine}.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class ValidatedModel<T> implements Model<T> {

    private final Model<T> model;
    private final ValidationEngine validation;

    @Override
    public <R> Rendered<R> print(final Media<R> media) {
        return media.asObject()
            .with("validation", this.validation.result())
            .with("model", this.model);
    }

    @Override
    public T value() {
        return this.model.value();
    }
}