package it.tasgroup.xtderp.xtdplatform.core.query.filter.json;

import it.tasgroup.xtderp.xtdplatform.core.query.filter.Filter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface FilterMatcher {

    boolean match();

    Filter matched();
}