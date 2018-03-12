package it.tasgroup.xtderp.xtdplatform.infrastructure.localization.service;

import it.tasgroup.xtderp.xtdplatform.infrastructure.localization.MultipleBundleMessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
@RequestMapping(value = "/i18n")
public class LocalizationService {

    @Autowired
    private MultipleBundleMessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public Properties getProperties() {
        return this.messageSource.getProperties();
    }

}
