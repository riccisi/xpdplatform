package it.tasgroup.xtderp.xtdplatform.infrastructure.action.result;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Result;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Printable;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.PrintableCollection;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.json.JsonMedia;
import lombok.RequiredArgsConstructor;
import org.cactoos.list.ListOf;

import java.io.OutputStream;
import java.util.Collection;
import java.util.List;

/**
 * {@link Result} that print a {@link Printable} asObject to an {@link OutputStream} using a {@link Media}.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class PrintableResult implements Result<OutputStream> {

    private final Printable result;

    private final Media<?> media;

    @Override
    public void writeOn(OutputStream stream) throws Exception {
        this.result.print(this.media).writeOn(stream);
    }
}