package it.tasgroup.xtderp.xtdplatform.core.action;

import lombok.RequiredArgsConstructor;
import org.cactoos.list.ListOf;

import java.util.Collection;

/**
 * {@link ActionLookup} decorator that in turn "decorate" the action returned by a lookup
 * through a collection of provided {@link ActionDecorator}
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class DecoratedActionLookup implements ActionLookup {

    private final ActionLookup lookup;

    private final Collection<ActionDecorator> decorators;

    public DecoratedActionLookup(final ActionLookup lookup, final ActionDecorator... decorators) {
        this(lookup, new ListOf<>(decorators));
    }

    @Override
    public Action get(final String id) throws Exception {
        Action action = this.lookup.get(id);
        for (final ActionDecorator decorator : this.decorators) {
            action = decorator.decorate(action);
        }
        return action;
    }
}