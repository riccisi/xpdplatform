package it.tasgroup.xtderp.xtdplatform.core.media.txt;

import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
final class TxtRenderedString extends TxtRendered {

    private final Serializable value;

    @Override
    public String value() {
        return String.format("%s", this.value);
    }
}