package it.tasgroup.xtderp.xtdplatform.core.media;

import lombok.RequiredArgsConstructor;
import org.cactoos.Func;
import org.cactoos.list.Mapped;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class PrintableList implements Printable {

    private final List<Printable> printables;

    public <T> PrintableList(final List<T> collection, final Func<T,Printable> func) {
        this.printables = new Mapped<>(func, collection);
    }

    public <T extends Printable> PrintableList(final Iterable<T> iterable)  {
        this.printables = new Mapped<>(Printable.class::cast, iterable);
    }

    @Override
    public <T> Rendered<T> print(final Media<T> media) {
        return media.asList().with(this.printables);
    }
}