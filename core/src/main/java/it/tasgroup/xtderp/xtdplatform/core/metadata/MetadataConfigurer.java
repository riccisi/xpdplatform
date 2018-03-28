package it.tasgroup.xtderp.xtdplatform.core.metadata;

public interface MetadataConfigurer {

    MetadataConfigurer EMPTY = metadataRegister -> {};

    void configure(MetadataRegister register);
}