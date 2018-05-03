package it.tasgroup.xtderp.xtdplatform.core.localization;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
public interface I18n {

    Object[] ARGS = {};

    String text(String code, Object[] args, String defaultMessage, Locale locale);

    default String text(final String code) {
        return this.text(code, ARGS);
    }

    default String text(final String code, final Object[] args) {
        return this.text(code, args, code);
    }

    default String text(final String code, final Object[] args, final String defaultMessage) {
        return this.text(code, args, defaultMessage, LocaleContextHolder.getLocale());
    }

    class Fake implements I18n {

        @Override
        public final String text(final String code, final Object[] args, final String defaultMessage, final Locale locale) {
            return code;
        }
    }
}