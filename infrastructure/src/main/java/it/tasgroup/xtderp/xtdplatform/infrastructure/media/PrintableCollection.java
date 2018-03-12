package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

import lombok.RequiredArgsConstructor;

import java.util.Collection;

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

    @Override
    public <T> Rendered<T> print(Media<T> media) {
        return media.list().with(this.printables);
    }
}
