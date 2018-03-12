package it.tasgroup.xtderp.xtdplatform.metadata.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ModelRegister {

    private final List<Model> models = new ArrayList<>();

    Iterator<Model> iterator() {
        return this.models.iterator();
    }

    public void add(Model model) {
        this.models.add(model);
    }
}
