package it.tasgroup.xtderp.xtdplatform.core.media.txt;

import lombok.RequiredArgsConstructor;

import java.text.DecimalFormat;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
final class TxtRenderedNumber extends TxtRendered {

    private final Number value;

    @Override
    public String value() {
        DecimalFormat df = new DecimalFormat( "#,###,###,##0.##" );
        return df.format(value);
    }
}
