package it.tasgroup.xtderp.xtdplatform.core.localization;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class MessageSourceI18n implements I18n {

    private final MessageSource source;

    @Override
    public String text(final String code, final Object[] args, final String defaultMessage, final Locale locale) {
        return this.source.getMessage(code, args, defaultMessage, locale);
    }
}
