package it.tasgroup.xtderp.xtdplatform.infrastructure.action.service;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Action;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Actions;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/action")
@RequiredArgsConstructor
public final class ActionService {

    @NonNull  private final Actions actions;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Action> get() {
        return this.actions;
    }
}
