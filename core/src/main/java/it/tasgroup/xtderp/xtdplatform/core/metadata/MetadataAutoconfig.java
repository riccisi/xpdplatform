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
@SuppressWarnings("DesignForExtension")
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
    public Metadata reloadableModels(final List<MetadataConfigurer> configurers) {
        return new ConfigurableMetadata(configurers);
    }

    @Bean
    @ConditionalOnMissingBean
    @Profile("dev")
    public MetadataLookup reloadableModelLookup(final Metadata metadata) {
        return new DefaultMetadataLookup(metadata);
    }

    @Bean
    @ConditionalOnMissingBean
    public Metadata models(final List<MetadataConfigurer> configurers) {
        return new CachedMetadata(new ConfigurableMetadata(configurers));
    }

    @Bean
    @ConditionalOnMissingBean
    public MetadataLookup modelLookup(final Metadata metadata) {
        return new CachedMetadataLookup(new DefaultMetadataLookup(metadata));
    }

    @Bean
    @ConditionalOnMissingBean
    public EntitiesMetadata entityMetadata(final Metadata metadata) {
        return new DefaultEntitiesMetadata(metadata);
    }

    @Bean
    @ConditionalOnMissingBean
    public ActionConfigurer entityActionConfigurer(final EntitiesMetadata metadata) {
        return new EntityActionConfigurer(metadata);
    }

    @Bean
    public MetadataService modelService(final Metadata metadata, final MetadataLookup metadataLookup) {
        return new MetadataService(metadata, metadataLookup);
    }

}