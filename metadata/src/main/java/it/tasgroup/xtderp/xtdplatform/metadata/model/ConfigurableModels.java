package it.tasgroup.xtderp.xtdplatform.metadata.model;

import lombok.RequiredArgsConstructor;

import java.util.Iterator;

@RequiredArgsConstructor
public class ConfigurableModels implements Models {

    private final Iterable<ModelConfigurer> configurers;

    @Override
    public Iterator<ModelMetadata> iterator() {
        ModelRegister register = new ModelRegister();
        this.configurers.forEach(configurer -> configurer.configure(register));
        return register.iterator();
    }

}