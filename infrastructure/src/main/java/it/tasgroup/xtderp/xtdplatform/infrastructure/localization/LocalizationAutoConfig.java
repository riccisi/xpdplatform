package it.tasgroup.xtderp.xtdplatform.infrastructure.localization;

import it.tasgroup.xtderp.xtdplatform.infrastructure.localization.parser.PropertiesToJsonSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.util.Properties;

public class LocalizationAutoConfig implements Jackson2ObjectMapperBuilderCustomizer {

    @Bean
    public MessageSource messageSource() {
        return new MultipleBundleMessageSource();
    }

    @Override
    public void customize(Jackson2ObjectMapperBuilder builder) {
        builder.serializerByType(Properties.class, new PropertiesToJsonSerializer());
    }
}