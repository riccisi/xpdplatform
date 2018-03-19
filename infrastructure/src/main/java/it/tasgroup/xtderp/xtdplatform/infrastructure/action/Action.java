package it.tasgroup.xtderp.xtdplatform.infrastructure.action;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Printable;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.infrastructure.util.Identified;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

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

    /**
     * Fake Action implementation class for testing purpose.
     */
    @RequiredArgsConstructor
    @EqualsAndHashCode
    @ToString
    final class Fake implements Action<String,StringBuffer> {

        private final String id;

        @Override
        public Result<StringBuffer> execute(Request<String> request) {
            return out -> out.append(request.value());
        }

        @Override
        public <R> Rendered<R> print(Media<R> media) {
            return media.asObject().with("id", this.id());
        }

        @Override
        public String id() {
            return this.id;
        }
    }
}