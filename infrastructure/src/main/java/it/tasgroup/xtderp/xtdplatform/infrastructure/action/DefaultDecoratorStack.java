package it.tasgroup.xtderp.xtdplatform.infrastructure.action;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class DefaultDecoratorStack implements ActionDecorator {

    @Override
    public Action decorate(Action action) {
        return new MonitoredAction(new LoggedAction(action));
    }
}
