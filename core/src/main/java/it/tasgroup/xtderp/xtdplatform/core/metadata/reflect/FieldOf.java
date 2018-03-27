package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.core.media.RenderedObject;
import it.tasgroup.xtderp.xtdplatform.core.metadata.Field;
import lombok.RequiredArgsConstructor;
import org.cactoos.collection.Filtered;
import org.cactoos.list.ListOf;

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public class FieldOf implements Field {

    private final Collection<FieldMatcher> matchers;

    public FieldOf(java.lang.reflect.Field field) {
        this(
            new Filtered<>(
                FieldMatcher::match,
                new ListOf<>(
                    new StringField.Matcher(field),
                    new ByteField.Matcher(field),
                    new CharField.Matcher(field),
                    new BooleanField.Matcher(field),
                    new ShortField.Matcher(field),
                    new IntField.Matcher(field),
                    new LongField.Matcher(field),
                    new FloatField.Matcher(field),
                    new DoubleField.Matcher(field),
                    new BigIntegerField.Matcher(field),
                    new BigDecimalField.Matcher(field),
                    new DateField.Matcher(field)
                )
            )
        );
    }

    @Override
    public <R, T> RenderedObject<R> printValue(T model, RenderedObject<R> rendered) {
        return this.matchedField().printValue(model, rendered);
    }

    @Override
    public <R> Rendered<R> print(Media<R> media) throws Exception {
        return this.matchedField().print(media);
    }

    private Field matchedField() {
        try {
            return this.matchers.iterator().next().matched();
        } catch (NoSuchElementException e) {
            throw new RuntimeException();
        }
    }
}