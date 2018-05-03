package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.RenderedObject;
import it.tasgroup.xtderp.xtdplatform.core.metadata.Formula;
import it.tasgroup.xtderp.xtdplatform.core.metadata.reflect.type.Type;
import it.tasgroup.xtderp.xtdplatform.core.metadata.reflect.type.TypeOf;
import lombok.NonNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
final class ClassFormula implements Formula {

    @NonNull private final Method method;
    @NonNull private final Type<?> type;

    ClassFormula(final Method method) throws Exception {
        this.method = method;
        this.type = new TypeOf<>(method.getReturnType());
    }

    @Override
    public String name() {
        return this.method.getName();
    }

    @Override
    public <R, T> RenderedObject<R> printValue(final T model, final RenderedObject<R> rendered) {
        try {
            this.method.setAccessible(true);
            final Object result = this.method.invoke(model);
            return rendered.with(this.method.getName(), this.type.printable(result));
        } catch (final IllegalAccessException|InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <R> RenderedObject<R> print(final Media<R> media) {
        return media.asObject()
            .with("name", this.method.getName())
            .with("type", this.type.name())
            .with("readonly", true);
    }
}