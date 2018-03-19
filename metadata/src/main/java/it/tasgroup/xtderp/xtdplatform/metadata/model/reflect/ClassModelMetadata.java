package it.tasgroup.xtderp.xtdplatform.metadata.model.reflect;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.metadata.model.Attribute;
import it.tasgroup.xtderp.xtdplatform.metadata.model.Field;
import it.tasgroup.xtderp.xtdplatform.metadata.model.ModelMetadata;
import it.tasgroup.xtderp.xtdplatform.metadata.model.annotation.XtdExclude;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequiredArgsConstructor
public class ClassModelMetadata<T> implements ModelMetadata {

    @NonNull private final Class<T> modelClass;

    @Override
    public String id() {
        return this.modelClass.getName();
    }

    @Override
    public Iterator<Attribute> iterator() {
        List<Attribute> fields = new ArrayList<>();
        ReflectionUtils.doWithFields(this.modelClass, field -> fields.add(this.buildField(field)), this::filter);
        return fields.iterator();
    }

    private Field buildField(java.lang.reflect.Field field) {
        switch (field.getType().getName()) {
            case "java.lang.String": return new StringField(field);
            case "java.lang.Byte": case "byte": return new ByteField(field);
            case "java.lang.Boolean": case "boolean": return new BooleanField(field);
            case "java.lang.Character": case "char": return new CharField(field);
            case "java.lang.Short": case "short": return new ShortField(field);
            case "int": case "java.lang.Integer": return new IntField(field);
            case "java.lang.Long": case "long": return new LongField(field);
            case "java.lang.Float": case "float": return new FloatField(field);
            case "java.lang.Double": case "double": return new DoubleField(field);
            case "java.math.BigInteger": return new BigIntegerField(field);
            case "java.math.BigDecimal": return new BigDecimalField(field);
            case "java.util.Date": return new DateField(field);
        }
        throw new IllegalArgumentException();
    }

    private boolean filter(java.lang.reflect.Field field) {
        return  !(Modifier.isStatic(field.getModifiers())) &&
                !(Modifier.isTransient(field.getModifiers())) &&
                !field.getName().startsWith("this$") &&
                !field.isAnnotationPresent(XtdExclude.class);
    }

    @Override
    public <T> Rendered<T> print(Media<T> media) {
        throw new UnsupportedOperationException("#print()");
    }
}