package it.tasgroup.xtderp.xtdplatform.infrastructure.action;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Action decorator that logs execution time.
 */
@RequiredArgsConstructor
@Slf4j
public final class MonitoredAction implements Action {

    private final Action action;

    @Override
    public String id() {
        return this.action.id();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Result execute(Request request) throws Exception {
        long startTimeMillis = System.currentTimeMillis();
        try {
            return this.action.execute(request);
        } finally {
            long lastTime = System.currentTimeMillis() - startTimeMillis;
            log.debug(String.format("Action '%s' executed in %d millis.", this.id(), lastTime));
        }
    }

    @Override
    public Rendered print(Media media) {
        return this.action.print(media);
    }
}