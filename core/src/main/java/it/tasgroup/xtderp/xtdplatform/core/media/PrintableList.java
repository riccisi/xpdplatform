package it.tasgroup.xtderp.xtdplatform.core.media;

import lombok.RequiredArgsConstructor;
import org.cactoos.Func;
import org.cactoos.iterable.IterableOf;
import org.cactoos.list.ListOf;
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

    public <T> PrintableList(List<T> collection, Func<T,Printable> mapFunction) {
        this.printables = new Mapped<>(mapFunction, collection);
    }

    public <T extends Printable> PrintableList(Iterable<T> iterable)  {
        this.printables = new Mapped<>(Printable.class::cast, iterable);
    }

    @Override
    public <T> Rendered<T> print(Media<T> media) {
        return media.asList().with(this.printables);
    }
}