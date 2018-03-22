package it.tasgroup.xtderp.xtdplatform.metadata.query;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;
import it.tasgroup.xtderp.xtdplatform.infrastructure.util.Identified;

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

    String modelId();

    QueryResult find(Request request) throws Exception;
}