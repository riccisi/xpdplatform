package it.tasgroup.xtderp.xtdplatform.core.action;

import lombok.RequiredArgsConstructor;
import org.cactoos.iterable.IterableOf;

import java.util.Iterator;

public interface Actions extends Iterable<Action> {

    /**
     * Fake Actions implementation class for testing purpose.
     */
    @RequiredArgsConstructor
    final class Fake implements Actions {

        private final Iterable<Action> actions;

        public Fake(final Action... action) {
            this.actions = new IterableOf<>(action);
        }

        @Override
        public Iterator<Action> iterator() {
            return this.actions.iterator();
        }
    }
}