package it.tasgroup.xtderp.xtdplatform.core.localization;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("DesignForExtension")
public class LocalizationAutoConfig {

    @Bean
    public MultipleBundleMessageSource messageSource() {
        return new MultipleBundleMessageSource();
    }

    @Bean
    public I18n i18n() {
        return new MessageSourceI18n(this.messageSource());
    }

}