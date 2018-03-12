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

/**
 * {@link Result} that print a {@link Printable} object to an {@link OutputStream} using a {@link Media}.
 *
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class PrintableResult implements Result<OutputStream> {

    private final Printable result;

    private final Media media;

    public PrintableResult(Collection<Printable> printable, Media media) {
        this(new PrintableCollection(printable), media);
    }

    public PrintableResult(Iterable<Printable> printable, Media media) {
        this(new PrintableCollection(new ListOf<>(printable)), media);
    }

    @Override
    public void printOn(OutputStream stream) throws Exception {
        this.result.print(this.media).writeOn(stream);
    }
}