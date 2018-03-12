package it.tasgroup.xtderp.xtdplatform.infrastructure.action;

import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class ActionNotFoundException extends Exception {
    
    private final String actionId;
    
}
