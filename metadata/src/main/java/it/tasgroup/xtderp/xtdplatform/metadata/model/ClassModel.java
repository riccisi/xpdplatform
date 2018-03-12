package it.tasgroup.xtderp.xtdplatform.metadata.model;

import it.tasgroup.xtderp.xtdplatform.metadata.model.annotation.XtdExclude;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequiredArgsConstructor
public class ClassModel<T> implements Model {

    @NonNull
    private final Class<T> modelClass;

    @Override
    public String id() {
        return this.modelClass.getName();
    }

    @Override
    public Iterator<Attribute> iterator() {
        List<Attribute> fields = new ArrayList<>();
        ReflectionUtils.doWithFields(this.modelClass,
                                     field -> fields.add(new ClassField(field)),
                                     field -> !(Modifier.isStatic(field.getModifiers())) &&
                                              !(Modifier.isTransient(field.getModifiers())) &&
                                              !field.getName().startsWith("this$") &&
                                              !field.isAnnotationPresent(XtdExclude.class));
        return fields.iterator();
    }

    @Override
    public ProcessedModel process() {
        return null;
    }
}