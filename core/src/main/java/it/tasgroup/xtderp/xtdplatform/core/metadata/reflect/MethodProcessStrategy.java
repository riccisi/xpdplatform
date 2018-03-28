package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect;

import it.tasgroup.xtderp.xtdplatform.core.metadata.Model;
import it.tasgroup.xtderp.xtdplatform.core.metadata.ModelProcessException;
import it.tasgroup.xtderp.xtdplatform.core.metadata.ProcessStrategy;
import lombok.RequiredArgsConstructor;
import org.cactoos.collection.Filtered;
import org.cactoos.iterable.LengthOf;
import org.cactoos.list.ListOf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * {@link ProcessStrategy} that perform the processing task calling an internal method of the model class with
 * the following signature:
 *
 * <pre> void process(); </pre>
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
public final class MethodProcessStrategy<T> implements ProcessStrategy<T> {

    private final Method process;

    public MethodProcessStrategy(final Class<T> modelClass) {
        this.process = new Filtered<>(
            method -> "process".equals(method.getName()),
            new ListOf<>(modelClass.getDeclaredMethods())
        ).iterator().next();
    }

    @Override
    public Model<T> apply(final Model<T> model) throws ModelProcessException {
        try {
            this.process.invoke(model.value());
            return model;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ModelProcessException(e);
        }
    }

    @RequiredArgsConstructor
    static final class Matcher<T> implements ProcessStrategyMatcher<T> {

        private final Class<T> modelClass;

        @Override
        public boolean match() {
            return
                new LengthOf(
                    new Filtered<>(
                        method -> "process".equals(method.getName()),
                        new ListOf<>(this.modelClass.getDeclaredMethods())
                    )
                ).intValue() > 0;
        }

        @Override
        public ProcessStrategy<T> matched() {
            return new MethodProcessStrategy<>(this.modelClass);
        }
    }
}