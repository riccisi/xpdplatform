package it.tasgroup.xtderp.xtdplatform.core.metadata.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@Target(TYPE)
@Retention(RUNTIME)
public @interface XtdMenu {

    String value();

    int order() default 0;
}