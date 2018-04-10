package it.tasgroup.xtderp.xtdplatform.prototype;

import it.tasgroup.xtderp.xtdplatform.core.localization.MultipleBundleMessageSource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@RequiredArgsConstructor
@SuppressWarnings("DesignForExtension")
public class PrototypeConfig {

    private final MultipleBundleMessageSource messageSource;

    @PostConstruct
    public void init() {
        this.messageSource.addResource("prototype");
    }
}