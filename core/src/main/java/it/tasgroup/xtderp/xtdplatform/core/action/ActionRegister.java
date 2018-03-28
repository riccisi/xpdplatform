package it.tasgroup.xtderp.xtdplatform.core.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class ActionRegister {

    private final Collection<Action> actions = new ArrayList<>(0);

    public void add(final Action action) {
        this.actions.add(action);
    }

    public Iterator<Action> iterator() {
        return this.actions.iterator();
    }
}