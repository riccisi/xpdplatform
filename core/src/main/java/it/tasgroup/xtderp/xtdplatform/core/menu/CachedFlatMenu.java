package it.tasgroup.xtderp.xtdplatform.core.menu;

import lombok.RequiredArgsConstructor;
import org.cactoos.iterable.StickyIterable;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class CachedFlatMenu implements FlatMenu {

    private final StickyIterable<MenuItem> cache;

    public CachedFlatMenu(final FlatMenu menu) {
        this.cache = new StickyIterable<>(menu);
    }

    @Override
    public Iterator<MenuItem> iterator() {
        return this.cache.iterator();
    }
}
