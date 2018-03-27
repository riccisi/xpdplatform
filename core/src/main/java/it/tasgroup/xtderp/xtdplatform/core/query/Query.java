package it.tasgroup.xtderp.xtdplatform.core.query;

import it.tasgroup.xtderp.xtdplatform.core.action.Request;
import it.tasgroup.xtderp.xtdplatform.core.util.Identified;

/**
 * The Query<br>.
 *
 * Represent
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface Query extends Identified {

    String modelId() throws Exception;

    QueryResult find(Request request) throws Exception;
}