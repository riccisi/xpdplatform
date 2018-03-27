package it.tasgroup.xtderp.xtdplatform.core.metadata;

import it.tasgroup.xtderp.xtdplatform.core.action.ActionConfigurer;
import it.tasgroup.xtderp.xtdplatform.core.metadata.action.EntityActionConfigurer;
import it.tasgroup.xtderp.xtdplatform.core.metadata.service.MetadataService;
import lombok.extern.java.Log;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Log
public class MetadataAutoconfig {

    @Bean
    @ConditionalOnMissingBean
    public MetadataConfigurer metaDataConfigurer() {
        log.warning("No metaData configurers has been defined!");
        return MetadataConfigurer.EMPTY;
    }

    @Bean
    @ConditionalOnMissingBean
    @Profile("dev")
    public Metadata reloadableModels(List<MetadataConfigurer> configurers) {
        return new ConfigurableMetadata(configurers);
    }

    @Bean
    @ConditionalOnMissingBean
    @Profile("dev")
    public MetadataLookup reloadableModelLookup(Metadata metadata) {
        return new DefaultMetadataLookup(metadata);
    }

    @Bean
    @ConditionalOnMissingBean
    public Metadata models(List<MetadataConfigurer> configurers) {
        return new CachedMetadata(new ConfigurableMetadata(configurers));
    }

    @Bean
    @ConditionalOnMissingBean
    public MetadataLookup modelLookup(Metadata metadata) {
        return new CachedMetadataLookup(new DefaultMetadataLookup(metadata));
    }

    @Bean
    @ConditionalOnMissingBean
    public EntitiesMetadata entityMetadata(Metadata metadata) {
        return new DefaultEntitiesMetadata(metadata);
    }

    @Bean
    @ConditionalOnMissingBean
    public ActionConfigurer entityActionConfigurer(EntitiesMetadata metadata) {
        return new EntityActionConfigurer(metadata);
    }

    @Bean
    public MetadataService modelService(Metadata metadata, MetadataLookup metadataLookup) {
        return new MetadataService(metadata, metadataLookup);
    }

}