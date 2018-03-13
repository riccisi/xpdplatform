package it.tasgroup.xtderp.xtdplatform.metadata.model.service;

import it.tasgroup.xtderp.xtdplatform.metadata.model.ModelLookup;
import it.tasgroup.xtderp.xtdplatform.metadata.model.Models;
import it.tasgroup.xtderp.xtdplatform.metadata.model.ModelMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/model")
public class ModelService {

    private final Models models;

    private final ModelLookup modelLookup;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<ModelMetadata> get() {
        return this.models;
    }

    @RequestMapping(value = "/{modelId}", method = RequestMethod.GET)
    public ModelMetadata get(@PathVariable("modelId") String modelId) {
        return this.modelLookup.get(modelId);
    }
}