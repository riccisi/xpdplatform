package it.tasgroup.xtderp.xtdplatform.metadata.model;

import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class DefaultModelLookup implements ModelLookup {

    private final Models models;

    @Override
    public ModelMetadata get(String modelId) {
        Stream<ModelMetadata> stream = StreamSupport.stream(this.models.spliterator(), false);
        return stream.filter(model -> model.id().equals(modelId)).findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
