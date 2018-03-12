package it.tasgroup.xtderp.xtdplatform.infrastructure.action;

import it.tasgroup.xtderp.xtdplatform.infrastructure.util.CachedIterable;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CachedActions extends CachedIterable<Action> implements Actions {

    private final Actions delegate;

    @Override
    protected Iterable<Action> iterable() {
        return this.delegate;
    }
}