package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class PrintableCollection implements Printable {

    private final Collection<Printable> printables;

    public <T> PrintableCollection(Collection<T> collection, Function<T,Printable> mapFunction) {
        this.printables = collection.stream().map(mapFunction).collect(Collectors.toList());
    }

    @Override
    public Rendered print(Media media) {
        return media.list().with(this.printables);
    }
}
