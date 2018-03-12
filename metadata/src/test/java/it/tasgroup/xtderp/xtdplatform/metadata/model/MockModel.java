package it.tasgroup.xtderp.xtdplatform.metadata.model;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.Iterator;

@RequiredArgsConstructor
@ToString
class MockModel implements Model {

    private final String name;

    @Override
    public String id() {
        return name;
    }

    @Override
    public ProcessedModel process() {
        return null;
    }

    @Override
    public Iterator iterator() {
        return Collections.emptyIterator();
    }
}
