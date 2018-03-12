package it.tasgroup.xtderp.xtdplatform.infrastructure.action;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.request.LoggedRequest;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public final class LoggedAction implements Action {

    @NonNull
    private final Action delegate;

    @Override
    public String id() {
        return this.delegate.id();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Result execute(Request request) throws Exception {
        boolean error = false;
        try {
            log.debug(String.format("Start execution of action '%s'", this.id()));
            return this.delegate.execute(new LoggedRequest(request));
        } catch (Exception e) {
            error = true;
            throw e;
        } finally {
            log.debug(String.format(error ? "Action execution '%s' failed!" : "action '%s' executed successfully", this.id()));
        }
    }

    @Override
    public <T> Rendered<T> print(Media<T> media) {
        return this.delegate.print(media);
    }
}
