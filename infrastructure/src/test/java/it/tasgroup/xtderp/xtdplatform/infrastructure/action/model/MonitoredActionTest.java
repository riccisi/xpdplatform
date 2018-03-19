package it.tasgroup.xtderp.xtdplatform.infrastructure.action.model;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Action;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.MonitoredAction;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;
import org.junit.Test;

public class MonitoredActionTest {

    @Test
    public void execute() throws Exception {
        MonitoredAction monitoredAction = new MonitoredAction(new Action.Fake("test"));
        monitoredAction.execute(Request.EMPTY);
    }
}