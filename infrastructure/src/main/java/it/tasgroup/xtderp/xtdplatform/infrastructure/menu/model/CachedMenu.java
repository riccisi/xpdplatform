package it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model;

import it.tasgroup.xtderp.xtdplatform.infrastructure.util.CachedIterable;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Decorator of a Menu (delegate) that caches subsequent calls to the iterator method.
 */
@RequiredArgsConstructor
public final class CachedMenu extends CachedIterable<MenuNode> implements Menu {

    private final Menu delegate;

    @Override
    protected Iterable<MenuNode> iterable() {
        return this.delegate;
    }
}