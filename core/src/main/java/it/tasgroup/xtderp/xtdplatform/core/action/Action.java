package it.tasgroup.xtderp.xtdplatform.core.action;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.core.util.Identified;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * The Action.<br>
 *
 * It's a cardinal rule of the overall core because represents a functionality exposed by the application.
 * Each pre-built functions provided by the platform is modeled by an Action.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface Action extends Identified, Printable {

    /**
     * An action can be executed calling this method.
     *
     * @param request
     * @return
     */
    Result execute(Request request) throws Exception;

    /**
     * Fake Action implementation class for testing purpose.
     */
    @RequiredArgsConstructor
    @EqualsAndHashCode
    @ToString
    final class Fake implements Action {

        private final String id;

        /**
         * A fake execute implementation: write to the output the value of the input.
         *
         * @param request
         * @return
         */
        @Override
        public Result execute(Request request) {
            return out -> out.writer().write(request.asString());
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