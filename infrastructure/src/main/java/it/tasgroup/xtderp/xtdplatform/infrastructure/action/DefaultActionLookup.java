package it.tasgroup.xtderp.xtdplatform.infrastructure.action;

import lombok.RequiredArgsConstructor;
import org.cactoos.collection.Filtered;

import java.util.Collection;

@RequiredArgsConstructor
public class DefaultActionLookup implements ActionLookup {

    private static final String DEFAULT_EXTENSION = "json";

    private final Actions actions;

    private final String defaultExtension;

    public DefaultActionLookup(Actions actions) {
        this(actions, DEFAULT_EXTENSION);
    }

    @Override
    public Action get(String id) throws ActionNotFoundException {
        Collection<Action> filtered = new Filtered<>(
            action -> id.equals(action.id()) || (id+"."+defaultExtension).equals(action.id()),
            this.actions
        );
        if(filtered.isEmpty()) {
            throw new ActionNotFoundException(id);
        }
        return filtered.iterator().next();
    }
}