package it.tasgroup.xtderp.xtdplatform.infrastructure.action.model;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Action;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.LoggedAction;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;
import org.junit.Test;

public class LoggedActionTest {

    @Test
    public void execute() throws Exception {
        LoggedAction action = new LoggedAction(new Action.Fake("test"));
        action.execute(Request.EMPTY);
    }
}