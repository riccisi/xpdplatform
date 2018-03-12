package it.tasgroup.xtderp.xtdplatform.infrastructure.localization;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

public class MultipleBundleMessageSource extends ReloadableResourceBundleMessageSource {

    private List<String> baseNames = new ArrayList<String>() {{
        this.add("classpath:messages");
    }};

    public void addResource(String resourceName) {
        String baseName = String.format("classpath:%s_messages", resourceName);
        baseNames.add(baseName);
        this.setBasenames(baseNames.toArray(new String[baseNames.size()]));
        this.clearCache();
    }

    public Properties getProperties() {
        Locale locale = LocaleContextHolder.getLocale();
        return this.getMergedProperties(locale).getProperties();
    }

}