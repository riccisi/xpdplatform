package it.tasgroup.xtderp.xtdplatform.core.metadata.service;

import it.tasgroup.xtderp.xtdplatform.core.metadata.Metadata;
import it.tasgroup.xtderp.xtdplatform.core.metadata.MetadataLookup;
import it.tasgroup.xtderp.xtdplatform.core.metadata.ModelMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/metadata")
public class MetadataService {

    private final Metadata metadata;

    private final MetadataLookup metadataLookup;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<ModelMetadata> get() {
        return this.metadata;
    }

    @RequestMapping(value = "/{metadataId}", method = RequestMethod.GET)
    public ModelMetadata get(@PathVariable("metadataId") String metadataId) throws Exception {
        return this.metadataLookup.get(metadataId);
    }
}