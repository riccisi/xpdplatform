package it.tasgroup.xtderp.xtdplatform.core.metadata.reflect.type;

import it.tasgroup.xtderp.xtdplatform.core.media.Printable;

import java.text.ParseException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
public interface Type<T> {

    String name();

    Printable printable(Object value);

    T value(String text) throws ParseException;

    interface TypeMatcher<T> {

        boolean match();

        Type<T> matched();
    }
}