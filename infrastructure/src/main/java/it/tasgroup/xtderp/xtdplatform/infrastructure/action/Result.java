package it.tasgroup.xtderp.xtdplatform.infrastructure.action;

/**
 * The Result.
 *
 * Represents the result produced by the execution of an {@link Action}.
 *
 * @param <T> Type of output on which the implementation of this interface expect to write.
 */
public interface Result<T> {

    Result EMPTY = ont -> {};

    void writeOn(T out) throws Exception;
}