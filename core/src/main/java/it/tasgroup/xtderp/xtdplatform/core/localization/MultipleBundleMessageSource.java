package it.tasgroup.xtderp.xtdplatform.core.localization;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.*;

public final class MultipleBundleMessageSource extends ReloadableResourceBundleMessageSource {

    private static final String[] STRINGS = new String[0];

    private final List<String> baseNames = new ArrayList<>(Arrays.asList("classpath:messages"));

    public void addResource(final String name) {
        this.baseNames.add(String.format("classpath:%s_messages", name));
        this.setBasenames(this.baseNames.toArray(STRINGS));
        this.clearCache();
    }

    public Properties getProperties() {
        final Locale locale = LocaleContextHolder.getLocale();
        return this.getMergedProperties(locale).getProperties();
    }
}