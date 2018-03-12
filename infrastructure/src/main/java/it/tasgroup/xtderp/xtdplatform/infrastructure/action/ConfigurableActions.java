package it.tasgroup.xtderp.xtdplatform.infrastructure.action;

import lombok.RequiredArgsConstructor;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public class ConfigurableActions implements Actions {

    private final Iterable<ActionConfigurer> configurers;

    @Override
    public Iterator<Action> iterator() {
        ActionRegister register = new ActionRegister();
        this.configurers.forEach(configurer -> configurer.configure(register));
        return register.iterator();
    }
}
