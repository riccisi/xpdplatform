package it.tasgroup.xtderp.xtdplatform.infrastructure.action.request;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public abstract class RequestDelegate<T> implements Request<T> {

    private final Request<T> delegate;

    @Override
    public final T value() throws Exception {
        return this.delegate.value();
    }
}
