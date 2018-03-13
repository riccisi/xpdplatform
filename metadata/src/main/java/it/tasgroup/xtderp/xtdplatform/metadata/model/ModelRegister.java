package it.tasgroup.xtderp.xtdplatform.metadata.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ModelRegister {

    private final List<ModelMetadata> modelMetadata = new ArrayList<>();

    Iterator<ModelMetadata> iterator() {
        return this.modelMetadata.iterator();
    }

    public void add(ModelMetadata modelMetadata) {
        this.modelMetadata.add(modelMetadata);
    }
}
