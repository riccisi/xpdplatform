package it.tasgroup.xtderp.xtdplatform.core.metadata.validation;

import it.tasgroup.xtderp.xtdplatform.core.metadata.ValidationEngine;
import it.tasgroup.xtderp.xtdplatform.core.metadata.ValidationResult;
import lombok.RequiredArgsConstructor;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * {@link ValidationEngine} implemented using the javax validator API.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class JavaxValidationEngine<T> implements ValidationEngine {

    private final Validator validator;
    private final T target;

    /**
     * Secondary ctor providing default validator.
     *
     * @param target
     */
    public JavaxValidationEngine(final T target) {
        this(Validation.buildDefaultValidatorFactory().getValidator(), target);
    }

    @Override
    public ValidationResult result() {
        return new JavaxValidationResult<>(this.validator.validate(this.target));
    }

}