package it.tasgroup.xtderp.xtdplatform.core.media.txt;

import lombok.RequiredArgsConstructor;

import java.util.Formatter;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class TxtRenderedBoolean extends TxtRendered {

    private final Boolean value;

    @Override
    public String value() {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.getDefault());
        formatter.format("%b", value);
        return sb.toString();
    }
}
