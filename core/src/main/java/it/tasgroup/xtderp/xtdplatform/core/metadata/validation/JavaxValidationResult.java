package it.tasgroup.xtderp.xtdplatform.core.metadata.validation;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.core.media.RenderedObject;
import it.tasgroup.xtderp.xtdplatform.core.metadata.ValidationResult;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintViolation;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class JavaxValidationResult<T> implements ValidationResult {

    private final Set<ConstraintViolation<T>> violations;

    @Override
    public boolean valid() {
        return this.violations.isEmpty();
    }

    @Override
    public <R> Rendered<R> print(final Media<R> media)  {
        final Map<String,List<String>> messages = new HashMap<>(this.violations.size());
        for (final ConstraintViolation<T> violation : this.violations) {
            final String field = violation.getPropertyPath().toString();
            final String message = violation.getMessage();
            messages.computeIfAbsent(field, key -> new ArrayList<>()).add(message);
        }
        RenderedObject<R> rendered = media.asObject().with("valid", this.valid());
        for (final Map.Entry<String, List<String>> entry : messages.entrySet()) {
            final List<String> value = entry.getValue();
            rendered = rendered.with(entry.getKey(), value.toArray(new String[0]));
        }
        return rendered;
    }
}