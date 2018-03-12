package it.tasgroup.xtderp.xtdplatform.infrastructure.action.request;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * {@link Request} decorator logging t
 * @param <T>
 */
@Slf4j
@RequiredArgsConstructor
public class LoggedRequest<T> implements Request<T> {

    @NonNull
    private final Request<T> delegate;

    @Override
    public T value() throws Exception {
        log.debug("Request: " + delegate);
        return this.delegate.value();
    }
}
