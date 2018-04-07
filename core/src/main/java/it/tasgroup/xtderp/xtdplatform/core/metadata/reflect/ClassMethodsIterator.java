package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Iterator over a all declared methods of a class, including those inherited from the parent classes.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
public final class ClassMethodsIterator implements Iterator<Method> {

    private final Iterator<Method> iterator;

    public ClassMethodsIterator(final Class<?> aClass) {
        final Collection<Method> methods = new ArrayList<>();
        final Iterator<Class<?>> it = new ClassInheritanceIterator(aClass);
        while (it.hasNext()) {
            methods.addAll(Arrays.asList(it.next().getDeclaredMethods()));
        }
        this.iterator = methods.iterator();
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public Method next() {
        return this.iterator.next();
    }
}