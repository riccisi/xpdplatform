package it.tasgroup.xtderp.xtdplatform.core.localization.service;

import it.tasgroup.xtderp.xtdplatform.core.localization.MultipleBundleMessageSource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
@RequestMapping(value = "/i18n")
@RequiredArgsConstructor
public class LocalizationService {

    private final MultipleBundleMessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public Properties getProperties() {
        return this.messageSource.getProperties();
    }

}