package it.tasgroup.xtderp.xtdplatform.metadata.model;

import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class DefaultModelLookup implements ModelLookup {

    private final Models models;

    @Override
    public Model get(String modelId) {
        Stream<Model> stream = StreamSupport.stream(this.models.spliterator(), false);
        return stream.filter(model -> model.id().equals(modelId)).findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
