package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect;

import it.tasgroup.xtderp.xtdplatform.core.metadata.Attribute;
import it.tasgroup.xtderp.xtdplatform.core.metadata.annotation.XtdFormula;
import lombok.RequiredArgsConstructor;
import org.cactoos.iterator.Filtered;
import org.cactoos.iterator.Mapped;

import java.util.Iterator;

/**
 * {@link Iterable} of attributes
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class Formulas implements Iterable<Attribute> {

    private final Class<?> modelClass;

    @Override
    public Iterator<Attribute> iterator() {
        return new Mapped<>(
            MethodFormula::new,
            new Filtered<>(
                method -> method.isAnnotationPresent(XtdFormula.class),
                new ClassMethodsIterator(this.modelClass)
            )
        );
    }
}