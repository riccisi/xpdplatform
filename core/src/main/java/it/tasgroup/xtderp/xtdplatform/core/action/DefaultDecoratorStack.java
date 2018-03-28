package it.tasgroup.xtderp.xtdplatform.core.action;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class DefaultDecoratorStack implements ActionDecorator {

    @Override
    public Action decorate(final Action action) {
        return new MonitoredAction(new LoggedAction(action));
    }
}