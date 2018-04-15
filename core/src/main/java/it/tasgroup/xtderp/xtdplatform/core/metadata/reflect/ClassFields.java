package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect;

import it.tasgroup.xtderp.xtdplatform.core.metadata.Attribute;
import it.tasgroup.xtderp.xtdplatform.core.metadata.Model;
import it.tasgroup.xtderp.xtdplatform.core.metadata.annotation.XtdExclude;
import lombok.RequiredArgsConstructor;
import org.cactoos.iterator.Filtered;
import org.cactoos.iterator.Mapped;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.Iterator;

/**
 * Iterable of fields for a {@link Model} represented by a Java Class.
 * Transients, statics or marked with {@link XtdExclude} are implicitly excluded.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class ClassFields implements Iterable<Attribute> {

    private final Class<?> modelClass;

    @Override
    public Iterator<Attribute> iterator() {
        return new Mapped<>(
            ClassField::new,
            new Filtered<>(
                ClassFields::shouldInclude,
                new ClassFieldsIterator(this.modelClass)
            )
        );
    }

    private static boolean shouldInclude(final Field field) {
        return notStatic(field) && notTransient(field) && notThis(field) && notToExclude(field);
    }

    private static boolean notToExclude(final AnnotatedElement field) {
        return !field.isAnnotationPresent(XtdExclude.class);
    }

    private static boolean notThis(final Member field) {
        return !field.getName().startsWith("this$");
    }

    private static boolean notTransient(final Member field) {
        return !Modifier.isTransient(field.getModifiers());
    }

    private static boolean notStatic(final Member field) {
        return !Modifier.isStatic(field.getModifiers());
    }
}