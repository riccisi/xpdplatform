package it.tasgroup.xtderp.xtdplatform.metadata.query;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Printable;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public abstract class QueryResult implements Printable {

    final List<Printable> result;

}