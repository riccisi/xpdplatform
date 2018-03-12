package it.tasgroup.xtderp.xtdplatform.infrastructure.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class ActionRegister {

    private final List<Action> actions = new ArrayList<>();

    public void add(Action action) {
        this.actions.add(action);
    }

    public Iterator<Action> iterator() {
        return this.actions.iterator();
    }
}
