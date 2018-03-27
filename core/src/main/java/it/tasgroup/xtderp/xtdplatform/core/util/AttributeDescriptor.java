package it.tasgroup.xtderp.xtdplatform.core.util;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.commons.lang.ClassUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import javax.validation.constraints.NotNull;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;

//import it.tasgroup.xtderp.xtdplatform.metadata.metadata.annotation.XtdExclude;

public class AttributeDescriptor {

    private java.lang.reflect.Field field;
    private PropertyDescriptor propertyDescriptor;
    private ObjectMapper mapper;

    AttributeDescriptor(java.lang.reflect.Field field, PropertyDescriptor propertyDescriptor) {
        this.field = field;
        this.propertyDescriptor = propertyDescriptor;

        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        this.mapper = builder.indentOutput(true).dateFormat(new SimpleDateFormat(Constant.DEFAULT_DATE_FORMAT)).build();
    }

    boolean hasGetter() {
        return this.propertyDescriptor != null && this.propertyDescriptor.getReadMethod() != null;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        AttributeDescriptor that = (AttributeDescriptor) o;

        if(field != null ? !field.equals(that.field) : that.field != null) return false;
        return propertyDescriptor != null ? propertyDescriptor.equals(that.propertyDescriptor) : that.propertyDescriptor == null;
    }

    @Override
    public int hashCode() {
        int result = field != null ? field.hashCode() : 0;
        result = 31 * result + (propertyDescriptor != null ? propertyDescriptor.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getName();
    }

   /* public boolean isToExclude() {
        return isFieldExcluded() || isMethodExcluded();
    }*/

    public String getName() {
        return field != null ? field.getName() : propertyDescriptor.getName();
    }

    public boolean isAnnotationPresent(Class annotationClass) {
        return field != null ? field.isAnnotationPresent(annotationClass) : (hasGetter() && propertyDescriptor.getReadMethod().isAnnotationPresent(annotationClass));
    }

    public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
        return field != null ? field.getAnnotation(annotationClass) : (hasGetter() ? propertyDescriptor.getReadMethod().getAnnotation(annotationClass): null);
    }

    public Class<?> getType() {
        return field != null ? field.getType() : propertyDescriptor.getPropertyType();
    }

    /*public boolean isFieldExcluded() {
        return field != null &&
                (field.isAnnotationPresent(XtdExclude.class) || field.isAnnotationPresent(JsonIgnore.class));
    }

    public boolean isMethodExcluded() {
        return hasGetter() &&
                (propertyDescriptor.getReadMethod().isAnnotationPresent(XtdExclude.class) ||
                        propertyDescriptor.getReadMethod().isAnnotationPresent(JsonIgnore.class));
    }*/

    /**
     * Returns true only if annotation managing mandatory doesn't have any group.
     */
    public boolean isFieldMandatory() {
        if(!(isAnnotationPresent(NotNull.class) || isAnnotationPresent(NotEmpty.class) ||
                isAnnotationPresent(NotBlank.class))) {
            return false;
        }

        boolean mandatory = false;
        if(isAnnotationPresent(NotNull.class)) {
            NotNull notNull = getAnnotation(NotNull.class);
            mandatory = notNull.groups().length == 0;
        }
        if(!mandatory && isAnnotationPresent(NotEmpty.class)) {
            NotEmpty notEmpty = getAnnotation(NotEmpty.class);
            mandatory = notEmpty.groups().length == 0;
        }
        if(!mandatory && isAnnotationPresent(NotBlank.class)) {
            NotBlank notBlank = getAnnotation(NotBlank.class);
            mandatory = notBlank.groups().length == 0;
        }
        return mandatory;
    }

    /**
     * Filed originated by getter will have persist=false
     *
     * @return
     */
    public boolean isFieldPersist() {
        return field != null;
    }

    public void parseAndSetValue(Object modelInstance, Object attrValue) {
        try {
            this.setValue(modelInstance, parseValue(attrValue));
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    public Object parseValue(Object attrValue) {
        return mapper.readValue(mapper.writeValueAsString(attrValue), field.getType());
    }

    @SneakyThrows
    public Object parseValue(String attrValue) {
        return mapper.readValue("\"" + attrValue + "\"", field.getType());
    }

    public void parseAndSetValue(Object modelInstance, String attrValue) {
        try {
            this.setValue(modelInstance, parseValue(attrValue));
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setValue(Object modelInstance, Object attrValue) {
        if(modelInstance == null) {
            return;
        }
        if(isFieldPersist()) {
            try {
                field.setAccessible(true);
                field.set(modelInstance, attrValue);
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Object getValue(Object modelInstance) {
        if(modelInstance == null) {
            return null;
        }
        try {
            if(this.hasGetter()) {
                Method getter = this.propertyDescriptor.getReadMethod();
                getter.setAccessible(true);
                return getter.invoke(modelInstance);
            }
            if(this.field != null) {
                field.setAccessible(true);
                return field.get(modelInstance);
            }
            return null;
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String parseType() {
/*
        if(this.isAnnotationPresent(XtdDomain.class)) {
            return "string";
        }
*/

        Class fieldType = this.getType();
        if(ClassUtils.wrapperToPrimitive(fieldType) != null) {
            fieldType = ClassUtils.wrapperToPrimitive(fieldType);
        }
        if(fieldType.isEnum()) {
            fieldType = String.class;
        }
        if(BigDecimal.class.equals(fieldType)) {
            fieldType = Double.class;
        }
        if(BigInteger.class.equals(fieldType)) {
            fieldType = Integer.class;
        }
        return fieldType.getSimpleName().toLowerCase();
    }

    public boolean isPersisted() {
        return this.isFieldPersist() /*&& !this.isAnnotationPresent(javax.persistence.Transient.class)*/;
    }
}
