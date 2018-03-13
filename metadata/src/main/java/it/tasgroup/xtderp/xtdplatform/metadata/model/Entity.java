package it.tasgroup.xtderp.xtdplatform.metadata.model;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface Entity extends Model {

    void save() throws Exception;

    void delete() throws Exception;
}
