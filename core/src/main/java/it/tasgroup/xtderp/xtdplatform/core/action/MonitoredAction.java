package it.tasgroup.xtderp.xtdplatform.core.action;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Action decorator that logs execution time.
 */
@RequiredArgsConstructor
@Slf4j
public final class MonitoredAction implements Action {

    @NonNull private final Action action;

    @Override
    public String id() throws Exception {
        return this.action.id();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Result execute(final Request request) throws Exception {
        final long start = System.currentTimeMillis();
        try {
            return this.action.execute(request);
        } finally {
            final long millis = System.currentTimeMillis() - start;
            log.debug(String.format("Action '%s' executed in %d millis.", this.id(), millis));
        }
    }

    @Override
    public <R> Rendered<R> print(final Media<R> media) throws Exception {
        return this.action.print(media);
    }
}