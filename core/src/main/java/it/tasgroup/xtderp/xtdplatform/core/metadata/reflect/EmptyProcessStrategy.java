package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect;

import it.tasgroup.xtderp.xtdplatform.core.metadata.Model;
import it.tasgroup.xtderp.xtdplatform.core.metadata.ProcessStrategy;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class EmptyProcessStrategy<T> implements ProcessStrategy<T> {

    @Override
    public Model<T> apply(final Model<T> model) {
        return model;
    }

    static final class Matcher<T> implements ProcessStrategyMatcher<T> {

        @Override
        public boolean match() {
            return true;
        }

        @Override
        public ProcessStrategy<T> matched() {
            return new EmptyProcessStrategy<T>();
        }
    }
}
