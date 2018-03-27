package it.tasgroup.xtderp.xtdplatform.core.action;

/**
 * Action
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface ActionDecorator {
    
    Action decorate(Action action);
}
