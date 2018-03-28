package it.tasgroup.xtderp.xtdplatform.core.metadata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class MetadataRegister {

    private final List<ModelMetadata> metadata = new ArrayList<>(0);

    Iterator<ModelMetadata> iterator() {
        return this.metadata.iterator();
    }

    public void add(ModelMetadata metadata) {
        this.metadata.add(metadata);
    }
}