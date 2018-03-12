package it.tasgroup.xtderp.xtdplatform.infrastructure.action;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Wrapper action class for "template" action stacks.<br>
 * Essentially it's an Action decorator "template" that can be extended passing the action stack to the super
 * constructor avoiding rewrite all methods to delegate.<br>
 * It's the same concept expressed <a href="">here</a>
 *
 */
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "action")
@ToString(of = "action")
public abstract class ActionWrapper<T,R> implements Action<T,R> {

    private final Action<T,R> action;

    @Override
    public final String id() {
        return this.action.id();
    }

    @Override
    @SuppressWarnings("unchecked")
    public final Result<R> execute(Request<T> request) throws Exception {
        return this.action.execute(request);
    }

    @Override
    public <M> Rendered<M> print(Media<M> media) {
        return this.action.print(media);
    }
}