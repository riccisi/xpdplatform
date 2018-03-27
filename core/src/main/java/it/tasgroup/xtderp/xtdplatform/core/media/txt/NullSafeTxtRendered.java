package it.tasgroup.xtderp.xtdplatform.core.media.txt;

import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
final class NullSafeTxtRendered extends TxtRendered {

    private final Object value;
    @NonNull private final Rendered<String> delegate;

    @Override
    public String value() throws Exception {
        return this.value != null ? this.delegate.value() : "null";
    }
}
