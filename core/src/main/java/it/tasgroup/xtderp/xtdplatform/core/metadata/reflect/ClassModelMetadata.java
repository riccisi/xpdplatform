package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.core.metadata.Attribute;
import it.tasgroup.xtderp.xtdplatform.core.metadata.Model;
import it.tasgroup.xtderp.xtdplatform.core.metadata.ModelMetadata;
import it.tasgroup.xtderp.xtdplatform.core.metadata.annotation.XtdExclude;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.cactoos.iterator.Filtered;
import org.cactoos.iterator.Mapped;
import org.cactoos.list.ListOf;

import java.lang.reflect.Modifier;
import java.util.Iterator;

/**
 * {@link ModelMetadata} of a {@link Model} represented by a Java class.
 * It gets attributes info using the Java reflection API.
 *
 * <p>The class is immutable and thread-safe.
 *
 * @param <T> the type of the introspected model class.
 */
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class ClassModelMetadata<T> implements ModelMetadata {

    @NonNull private final Class<T> modelClass;

    /**
     * The id of the metadata it's the name of class.
     *
     * @return
     */
    @Override
    public String id() {
        return this.modelClass.getName();
    }

    @Override
    public Iterator<Attribute> iterator() {
        return new Mapped<>(
            FieldOf::new,
            new Filtered<>(
                field -> !(Modifier.isStatic(field.getModifiers())) &&
                         !(Modifier.isTransient(field.getModifiers())) &&
                         !field.getName().startsWith("this$") &&
                         !field.isAnnotationPresent(XtdExclude.class),
                new ClassFieldIterator(this.modelClass)
            )
        );
    }

    @Override
    public <R> Rendered<R> print(Media<R> media) {
        return media.asObject()
            .with("id", this.id())
            .with("type", "metadata")
            .with("attributes", new ListOf<>((Printable) this.iterator()));
    }

    @Override
    public ClassModel<T> newInstance() throws Exception {
        return new ClassModel<>(this.modelClass.newInstance(), this);
    }
}