package it.tasgroup.xtderp.xtdplatform.infrastructure.action.model;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Action;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.LoggedAction;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;
import org.junit.Test;

public class LoggedActionTest {

    @Test
    public void execute() {
        LoggedAction action = new LoggedAction(Action.EMPTY);
        try {
            action.execute(Request.EMPTY);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}