package it.tasgroup.xtderp.xtdplatform.infrastructure.action.service;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Action;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.ActionLookup;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.output.HttpOutput;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.request.HttpRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Service exposing action execution to the world!
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/action")
@RequiredArgsConstructor
public final class ActionExecutionService {

    @NonNull  private final ActionLookup lookup;

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.POST)
    @SuppressWarnings("unchecked")
    public void execute(
            @PathVariable(value = "id") String id,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        Action action = this.lookup.get(id);
        action.execute(new HttpRequest(request)).writeOn(new HttpOutput(response));
    }
}