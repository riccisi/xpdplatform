package it.tasgroup.xtderp.xtdplatform.metadata.model;

import lombok.extern.java.Log;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Log
public class ModelAutoconfig {

    @Bean
    @ConditionalOnMissingBean
    public ModelConfigurer metaDataConfigurer() {
        log.warning("No metaData configurers has been defined!");
        return ModelConfigurer.EMPTY;
    }

    @Bean
    @ConditionalOnMissingBean
    @Profile("dev")
    public Models reloadableModels(List<ModelConfigurer> configurers) {
        return new ConfigurableModels(configurers);
    }

    @Bean
    @ConditionalOnMissingBean
    @Profile("dev")
    public ModelLookup reloadableModelLookup(Models models) {
        return new DefaultModelLookup(models);
    }

    @Bean
    @ConditionalOnMissingBean
    public Models models(List<ModelConfigurer> configurers) {
        return new CachedModels(new ConfigurableModels(configurers));
    }

    @Bean
    @ConditionalOnMissingBean
    public ModelLookup modelLookup(Models models) {
        return new CachedModelLookup(new DefaultModelLookup(models));
    }

}