package it.tasgroup.xtderp.xtdplatform.metadata.model;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.Iterator;

@RequiredArgsConstructor
@ToString
class MockModelMetadata implements ModelMetadata {

    private final String name;

    @Override
    public String id() {
        return name;
    }

    @Override
    public Iterator iterator() {
        return Collections.emptyIterator();
    }

    @Override
    public <T> Rendered<T> print(Media<T> media) {
        throw new UnsupportedOperationException("#print()");
    }
}
