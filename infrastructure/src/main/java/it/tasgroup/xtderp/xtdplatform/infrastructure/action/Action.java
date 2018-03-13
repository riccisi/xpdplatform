package it.tasgroup.xtderp.xtdplatform.infrastructure.action;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Printable;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.infrastructure.util.Identified;

/**
 * The Action.<br>
 *
 * Represents a functionality exposed by the application.
 *
 * @param <T> The type of the request
 * @param <R> The type of the result.
 */
public interface Action<T,R> extends Identified, Printable {

    /**
     * An action can be executed calling this method.
     *
     * @param request
     * @return
     */
    Result<R> execute(Request<T> request) throws Exception;

    Action EMPTY = new Action() {
        @Override
        public Rendered print(Media media) {
            return Rendered.EMPTY;
        }

        @Override
        public String id() {
            return "empty";
        }

        @Override
        public Result execute(Request request) {
            return Result.EMPTY;
        }
    };
}