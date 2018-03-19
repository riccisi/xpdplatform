package it.tasgroup.xtderp.xtdplatform.infrastructure.action.service;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Action;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.ActionLookup;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Actions;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Service exposing action asList and action execution to the world!
 */
@RestController
@RequestMapping(value = "/action")
@RequiredArgsConstructor
public class ActionService {

    private final Actions actions;

    private final ActionLookup lookup;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Action> get() {
        return this.actions;
    }

    @RequestMapping(value = "/{id:.+}", method = {RequestMethod.POST,RequestMethod.GET})
    @SuppressWarnings("unchecked")
    public void execute(
            @PathVariable(value = "id") String id,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        Action<HttpServletRequest,HttpServletResponse> action = this.lookup.get(id);
        action.execute(() -> request).writeOn(response);
    }
}