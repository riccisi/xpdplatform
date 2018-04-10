package it.tasgroup.xtderp.xtdplatform.core.metadata;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Iterator;

@RequiredArgsConstructor
public final class ConfigurableMetadata implements Metadata {

    @NonNull  private final Iterable<MetadataConfigurer> configurers;

    @Override
    public Iterator<ModelMetadata<?>> iterator() {
        final MetadataRegister register = new MetadataRegister();
        this.configurers.forEach(configurer -> configurer.configure(register));
        return register.iterator();
    }
}