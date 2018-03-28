package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect;

import it.tasgroup.xtderp.xtdplatform.core.metadata.ProcessStrategy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
public interface ProcessStrategyMatcher<T> {

    boolean match();

    ProcessStrategy<T> matched();
}
