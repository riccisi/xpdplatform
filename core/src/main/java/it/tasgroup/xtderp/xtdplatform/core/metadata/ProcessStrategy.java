package it.tasgroup.xtderp.xtdplatform.core.metadata;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
public interface ProcessStrategy<T> {

    Model<T> apply(Model<T> model) throws ModelProcessException;
}
