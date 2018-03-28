package it.tasgroup.xtderp.xtdplatform.core.metadata;

import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class ModelProcessException extends Exception {

    private static final long serialVersionUID = -6600051608699987476L;

    public ModelProcessException(final Throwable cause) {
        super(cause);
    }
}