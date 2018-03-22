package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

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

    public <T> PrintableList(List<T> collection, Func<T,Printable> mapFunction) {
        this.printables = new Mapped<>(mapFunction, collection);
    }

    @Override
    public <T> Rendered<T> print(Media<T> media) {
        return media.asList().with(this.printables);
    }
}