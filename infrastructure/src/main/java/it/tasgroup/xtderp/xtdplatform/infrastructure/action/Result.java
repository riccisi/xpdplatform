package it.tasgroup.xtderp.xtdplatform.infrastructure.action;

/**
 * The Result.
 *
 * Represents the result produced by the execution of an {@link Action}.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface Result {

    void writeOn(Output output) throws Exception;
}