package it.tasgroup.xtderp.xtdplatform.core.media;

import it.tasgroup.xtderp.xtdplatform.core.media.json.PrintableJsonSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
@SuppressWarnings("DesignForExtension")
public class MediaAutoConfig implements Jackson2ObjectMapperBuilderCustomizer {

    @Override
    public void customize(final Jackson2ObjectMapperBuilder builder) {
        builder.serializerByType(Printable.class, new PrintableJsonSerializer());
    }
}
