package it.tasgroup.xtderp.xtdplatform.infrastructure.action;

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
