package it.tasgroup.xtderp.xtdplatform.infrastructure.util;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Classe astratta che effettua un lookup da un iterable di oggetti identificabili mediante un ID
 */
public abstract class IterableLookup<T extends Identified> implements IdentifiableLookup<T>  {

    @Override
    public T get(String id) {
        Stream<T> stream = StreamSupport.stream(this.iterable().spliterator(), false);
        return stream.filter(identified -> identified.id().equals(id)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    protected abstract Iterable<T> iterable();
}
