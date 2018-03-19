package it.tasgroup.xtderp.xtdplatform.infrastructure.action;

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

        public Fake(Action... actions) {
            this.actions = new IterableOf<>(actions);
        }

        @Override
        public Iterator<Action> iterator() {
            return this.actions.iterator();
        }
    }
}