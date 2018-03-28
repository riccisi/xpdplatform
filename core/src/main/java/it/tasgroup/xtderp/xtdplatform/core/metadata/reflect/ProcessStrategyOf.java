package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect;

import it.tasgroup.xtderp.xtdplatform.core.metadata.Model;
import it.tasgroup.xtderp.xtdplatform.core.metadata.ModelProcessException;
import it.tasgroup.xtderp.xtdplatform.core.metadata.ProcessStrategy;
import lombok.RequiredArgsConstructor;
import org.cactoos.collection.Filtered;
import org.cactoos.list.ListOf;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class ProcessStrategyOf<T> implements ProcessStrategy<T> {

    private final Collection<ProcessStrategyMatcher<T>> matchers;

    public ProcessStrategyOf(final Class<T> modelClass) {
        this(
            new Filtered<>(
                ProcessStrategyMatcher::match,
                new ListOf<>(
                    new MethodProcessStrategy.Matcher<T>(modelClass),
                    new EmptyProcessStrategy.Matcher<T>()
                )
            )
        );
    }

    @Override
    public Model<T> apply(Model<T> model) throws ModelProcessException {
        return this.matched().apply(model);
    }

    private ProcessStrategy<T> matched() {
        return this.matchers.iterator().next().matched();
    }
}