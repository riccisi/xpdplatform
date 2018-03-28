package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Iterator over a all declared field of a class, including those inherited from the parent classes.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
public final class ClassFieldIterator implements Iterator<Field> {

    private final Iterator<Field> iterator;

    public ClassFieldIterator(Class aClass) {
        List<Field> fields = new ArrayList<>();
        ClassInheritanceIterator it = new ClassInheritanceIterator(aClass);
        while (it.hasNext()) {
            fields.addAll(Arrays.asList(it.next().getDeclaredFields()));
        }
        this.iterator = fields.iterator();
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public Field next() {
        return this.iterator.next();
    }
}
