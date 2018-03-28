package it.tasgroup.xtderp.xtdplatform.core.query;

import it.tasgroup.xtderp.xtdplatform.core.media.Printable;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
public interface QueryResult extends Printable {

    List<Printable> result();
}