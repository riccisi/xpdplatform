package it.tasgroup.xtderp.xtdplatform.core.action;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public final class LoggedAction implements Action {

    @NonNull
    private final Action delegate;

    @Override
    public String id() throws Exception {
        return this.delegate.id();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Result execute(Request request) throws Exception {
        try {
            log.debug(String.format("Start execution of action '%s'", this.id()));
            Result result = this.delegate.execute(request);
            log.debug(String.format("Action '%s' executed successfully!", this.id()));
            return result;
        } catch (Throwable e) {
            log.debug(String.format("Action execution '%s' failed!", this.id()));
            throw e;
        }
    }

    @Override
    public <R> Rendered<R> print(Media<R> media) throws Exception {
        return this.delegate.print(media);
    }
}