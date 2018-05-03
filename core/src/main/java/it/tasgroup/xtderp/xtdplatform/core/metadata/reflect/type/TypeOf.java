package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect.type;

import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import lombok.RequiredArgsConstructor;
import org.cactoos.collection.Filtered;
import org.cactoos.list.ListOf;
import org.cactoos.scalar.ItemAt;

import java.text.ParseException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class TypeOf<T> implements Type<T> {

    private final Type<?> delegate;

    public TypeOf(final Class<T> type) throws Exception {
        this(
            new ItemAt<>(
                new Filtered<>(
                    TypeMatcher::match,
                    new ListOf<>(
                        new StringType.Matcher(type),
                        new ByteType.Matcher(type),
                        new CharType.Matcher(type),
                        new BooleanType.Matcher(type),
                        new ShortType.Matcher(type),
                        new IntType.Matcher(type),
                        new LongType.Matcher(type),
                        new FloatType.Matcher(type),
                        new DoubleType.Matcher(type),
                        new BigIntegerType.Matcher(type),
                        new BigDecimalType.Matcher(type),
                        new DateType.Matcher(type)
                    )
                )
            ).value().matched()
        );
    }

    @Override
    public String name() {
        return this.delegate.name();
    }

    @Override
    public Printable printable(final Object value) {
        return this.delegate.printable(value);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T value(final String text) throws ParseException {
        return (T) this.delegate.value(text);
    }
}