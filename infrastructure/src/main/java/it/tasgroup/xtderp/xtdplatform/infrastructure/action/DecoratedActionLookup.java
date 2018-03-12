package it.tasgroup.xtderp.xtdplatform.infrastructure.action;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
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
public class DecoratedActionLookup implements ActionLookup {

    private final ActionLookup lookup;

    private final Collection<ActionDecorator> decorators;

    public DecoratedActionLookup(ActionLookup lookup, ActionDecorator... decorators) {
        this(lookup, Arrays.asList(decorators));
    }

    @Override
    public Action get(String id) throws ActionNotFoundException {
        Action action = this.lookup.get(id);
        for (ActionDecorator decorator : this.decorators) {
            action = decorator.decorate(action);
        }
        return action;
    }
}