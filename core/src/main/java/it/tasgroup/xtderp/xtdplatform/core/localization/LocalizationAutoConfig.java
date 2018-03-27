package it.tasgroup.xtderp.xtdplatform.core.localization;

import it.tasgroup.xtderp.xtdplatform.core.localization.parser.PropertiesToJsonSerializer;
import it.tasgroup.xtderp.xtdplatform.core.localization.service.LocalizationService;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.util.Properties;

public class LocalizationAutoConfig implements Jackson2ObjectMapperBuilderCustomizer {

    @Bean
    public MultipleBundleMessageSource messageSource() {
        return new MultipleBundleMessageSource();
    }

    @Bean
    public LocalizationService localizationService(MultipleBundleMessageSource messageSource) {
        return new LocalizationService(messageSource);
    }

    @Override
    public void customize(Jackson2ObjectMapperBuilder builder) {
        builder.serializerByType(Properties.class, new PropertiesToJsonSerializer());
    }
}