package it.tasgroup.xtderp.xtdplatform.core.action;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface ActionConfigurer {

    ActionConfigurer EMPTY = register -> {};

    void configure(ActionRegister register);
}
