package it.tasgroup.xtderp.xtdplatform.core.metadata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class MetadataRegister {

    private final Collection<ModelMetadata<?>> metadata = new ArrayList<>(0);

    Iterator<ModelMetadata<?>> iterator() {
        return this.metadata.iterator();
    }

    public void add(final ModelMetadata<?> metadata) {
        this.metadata.add(metadata);
    }
}