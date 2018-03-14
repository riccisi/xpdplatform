package it.tasgroup.xtderp.xtdplatform.metadata.query;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Printable;
import it.tasgroup.xtderp.xtdplatform.infrastructure.util.Identified;

/**
 * @todo #7 split into query and paged query
 *
 * The Query<br>.
 * Represent
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface Query extends Identified {

    String modelId();

    Printable find(Condition condition);

    Printable find(Condition condition, int page, int limit);
}