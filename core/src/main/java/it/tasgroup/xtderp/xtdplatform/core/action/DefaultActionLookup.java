package it.tasgroup.xtderp.xtdplatform.core.action;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cactoos.iterable.Filtered;
import org.cactoos.scalar.ItemAt;

/**
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class DefaultActionLookup implements ActionLookup {

    private static final String DEFAULT_EXTENSION = "json";

    /**
     * Action Iterable where to perform the lookup.
     */
    @NonNull  private final Actions actions;

    /**
     * The default extension automatically appended
     */
    @NonNull private final String defaultExtension;

    /**
     * Overloaded constructor
     *
     * @param actions the iterable of Action.
     */
    public DefaultActionLookup(final Actions actions) {
        this(actions, DEFAULT_EXTENSION);
    }

    /**
     *
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Action get(final String id) throws Exception {
        return
            new ItemAt<>(
                0,
                new Filtered<>(
                    act -> id.equals(act.id()) || String.format("%s.%s",id,this.defaultExtension).equals(act.id()),
                    this.actions
                )
            ).value();
    }
}