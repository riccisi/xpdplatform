package it.tasgroup.xtderp.xtdplatform.infrastructure.action;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cactoos.list.ListOf;

/**
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public class DefaultActionLookup implements ActionLookup {

    private static final String DEFAULT_EXTENSION = "json";

    /**
     * Action Iterable where to perform the lookup.
     */
    @NonNull  private final Actions actions;

    /**
     * The default extension automatically appended
     */
    private final String defaultExtension;

    /**
     * Overloaded constructor
     *
     * @param actions the iterable of Action.
     */
    public DefaultActionLookup(Actions actions) {
        this(actions, DEFAULT_EXTENSION);
    }

    /**
     *
     *
     * @param id
     * @return
     * @throws ActionNotFoundException
     */
    @Override
    public Action get(String id) throws ActionNotFoundException {
        return new ListOf<>(this.actions)
            .stream()
            .filter(action -> id.equals(action.id()) || (id+"."+defaultExtension).equals(action.id()))
            .findFirst()
            .orElseThrow(() -> new ActionNotFoundException(id));
    }
}