package it.tasgroup.xtderp.xtdplatform.metadata.model;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClassField implements Field {

    @NonNull
    private final java.lang.reflect.Field field;

    @Override
    public String name() {
        return this.field.getName();
    }

    @Override
    public String type() {
        return this.field.getType().getName();
    }

    @Override
    public String toString() {
        return "ClassField(" +this.name() + ", " + this.type() + ")";
    }
}
