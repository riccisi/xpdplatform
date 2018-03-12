package it.tasgroup.xtderp.xtdplatform.infrastructure.action.model;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Action;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.MonitoredAction;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;
import org.junit.Test;

public class MonitoredActionTest {

    @Test
    public void execute() {
        MonitoredAction monitoredAction = new MonitoredAction(Action.EMPTY);
        try {
            monitoredAction.execute(Request.EMPTY);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}