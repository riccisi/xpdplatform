package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.core.metadata.*;
import it.tasgroup.xtderp.xtdplatform.core.metadata.annotation.XtdExclude;
import it.tasgroup.xtderp.xtdplatform.core.metadata.validation.JavaxValidationEngine;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.cactoos.iterator.Filtered;
import org.cactoos.iterator.Mapped;
import org.cactoos.list.ListOf;

import java.lang.reflect.*;
import java.lang.reflect.Field;
import java.util.Iterator;

/**
 * {@link ModelMetadata} of a {@link Model} represented by a Java class.
 * It gets attributes info using the Java reflection API.
 *
 * <p>The class is immutable and thread-safe.
 *
 * @param <T> the type of the introspected modelClass class.
 */
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public final class ClassModelMetadata<T> implements ModelMetadata {

    @NonNull private final Class<T> modelClass;
    @NonNull private final ProcessStrategy<T> strategy;

    public ClassModelMetadata(final Class<T> modelClass) {
        this(modelClass, new ProcessStrategyOf<T>(modelClass));
    }

    @Override
    public String id() {
        return this.modelClass.getName();
    }

    @Override
    public Iterator<Attribute> iterator() {
        return new Mapped<>(
            FieldOf::new,
            new Filtered<>(
                ClassModelMetadata::included,
                new ClassFieldIterator(this.modelClass)
            )
        );
    }

    @Override
    public <R> Rendered<R> print(final Media<R> media) {
        return media.asObject()
            .with("id", this.id())
            .with("type", "metadata")
            .with("attributes", new ListOf<>((Printable) this.iterator()));
    }

    @Override
    public Model<T> newInstance() throws Exception {
        final Constructor<T> ctor = this.modelClass.getDeclaredConstructor();
        ctor.setAccessible(true);
        final T instance = ctor.newInstance();
        return
            new ValidatedModel<>(
                new ProcessedModel<>(
                    new ClassModel<>(instance, this),
                    this.strategy
                ),
                new JavaxValidationEngine<>(instance)
            );
    }

    private static boolean included(final Field field) {
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