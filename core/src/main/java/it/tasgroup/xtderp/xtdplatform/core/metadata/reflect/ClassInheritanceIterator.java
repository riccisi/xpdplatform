package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Iterator over a class inheritance, ordered from parent to child.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
public final class ClassInheritanceIterator implements Iterator<Class> {

    private final ListIterator<Class<?>> it;

    public ClassInheritanceIterator(Class aClass) {
        List<Class<?>> classes = new ArrayList<>();
        Class<?> current = aClass;
        do {
            classes.add(current);
            current = current.getSuperclass();
        }
        while (current != null && current != Object.class);
        it = classes.listIterator(classes.size());
    }

    @Override
    public boolean hasNext() {
        return it.hasPrevious();
    }

    @Override
    public Class next() {
        return it.previous();
    }
}
