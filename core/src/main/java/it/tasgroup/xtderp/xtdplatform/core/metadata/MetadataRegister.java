package it.tasgroup.xtderp.xtdplatform.core.metadata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class MetadataRegister {

    private final List<ModelMetadata> modelMetadata = new ArrayList<>();

    Iterator<ModelMetadata> iterator() {
        return this.modelMetadata.iterator();
    }

    public void add(ModelMetadata modelMetadata) {
        this.modelMetadata.add(modelMetadata);
    }
}
