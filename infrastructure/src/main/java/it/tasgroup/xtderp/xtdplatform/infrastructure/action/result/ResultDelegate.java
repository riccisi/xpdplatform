package it.tasgroup.xtderp.xtdplatform.infrastructure.action.result;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Result;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public abstract class ResultDelegate<T> implements Result<T> {

    private final Result<T> delegate;

    @Override
    public final void writeOn(T out) throws Exception {
        this.delegate.writeOn(out);
    }
}
