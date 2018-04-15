package it.tasgroup.xtderp.xtdplatform.core.mvc;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@Configuration
@Log
@SuppressWarnings({"DesignForExtension","MethodDoesntCallSuperMethod"})
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Value("${external.resources.path}")
    private String externalResourcesPath;

    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index.html");
        registry.addViewController("/").setViewName("index");
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        log.info(String.format("Static resources loading from: %s", this.externalResourcesPath));
        registry.addResourceHandler("/**").addResourceLocations(this.externalResourcesPath);
    }
}