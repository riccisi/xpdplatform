package it.tasgroup.xtderp.xtdplatform.infrastructure.util;

import com.google.common.base.Predicate;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class ReflectionUtils {

    public static final String GET = "get";
    public static final String IS = "is";
    public static final String HAS = "has";

    public static <T> Field getFieldsUpTo(Class<T> modelClass, Class<?> exclusiveParent, String fieldName){
        Field field = null;
        try{
            field = modelClass.getDeclaredField(fieldName);
        }catch(NoSuchFieldException nsfe){
            Class<?> parentClass = modelClass.getSuperclass();
            if (parentClass != null && (exclusiveParent == null || !(parentClass.equals(exclusiveParent)))) {
                return getFieldsUpTo(parentClass, exclusiveParent, fieldName);
            }
        } catch(Exception e){
            throw new RuntimeException(e);
        }
        return field;
    }

    public static Object getFieldValue(String fieldName, Object pojo) {
        try {
            Field field = getFieldsUpTo(pojo.getClass(), Object.class, fieldName);
            field.setAccessible(true);
            return field.get(pojo);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isGetterMethod(Method method) {
        if(Modifier.isStatic(method.getModifiers())) {
            return false;
        }
        if (method.getParameterTypes().length != 0) {
            return false;
        }
        String methodName = method.getName();
        //<PropertyType> get<PropertyName>()
        if (methodName.startsWith(GET) && method.getReturnType() != void.class ) {
            return true;
        }
        //boolean is<PropertyName>()
        else if (methodName.startsWith(IS) && method.getReturnType() == boolean.class ) {
            return true;
        }
        //boolean has<PropertyName>()
        else if (methodName.startsWith(HAS) && method.getReturnType() == boolean.class ) {
            return true;
        }

        return false;
    }

    public static String getPropertyNameFromGetter(Method method) {
        String name = method.getName();
        if(name.startsWith(GET) || name.startsWith(HAS)) {
            return name.substring(3, 4).toLowerCase() + name.substring(4);
        }
        if(name.startsWith(IS)) {
            return name.substring(2, 3).toLowerCase() + name.substring(3);
        }
        throw new IllegalArgumentException("The method " + method + " isn't a getter");
    }

    public static boolean isInterfaceMethod(Class interfaceClass, Method method) {
        try {
            interfaceClass.getMethod(method.getName(), method.getParameterTypes());
        } catch(NoSuchMethodException e) {
            return false;
        }
        return true;
    }

    public static <T> Set<AttributeDescriptor> getAttributeDescriptors(Class<T> modelClass) {
        Set<AttributeDescriptor> attributeDescriptors = new HashSet<>();
        Set<java.lang.reflect.Field> fieldSet = org.reflections.ReflectionUtils.getAllFields(modelClass, (Predicate<Field>) field -> !Modifier.isStatic(field.getModifiers()));

        PropertyDescriptor[] props = PropertyUtils.getPropertyDescriptors(modelClass);
        Map<String, PropertyDescriptor> descriptorMap = new HashMap<>();
        for(final PropertyDescriptor prop : props) {
            if(prop.getName().equals("class")) {
                continue;
            }
            descriptorMap.put(prop.getName(), prop);
            java.lang.reflect.Field field = (java.lang.reflect.Field) CollectionUtils.find(fieldSet, new org.apache.commons.collections.Predicate() {
                @Override
                public boolean evaluate(Object object) {
                    return ((java.lang.reflect.Field) object).getName().equals(prop.getName());
                }
            });
            attributeDescriptors.add(new AttributeDescriptor(field, prop));
        }

        for(java.lang.reflect.Field field : fieldSet) {
            attributeDescriptors.add(new AttributeDescriptor(field, descriptorMap.get(field.getName())));
        }
        return attributeDescriptors;
    }

    public static <T> AttributeDescriptor getAttributeDescriptor(final String fieldName, Class<T> modelClass) {
        Set<java.lang.reflect.Field> fieldSet = org.reflections.ReflectionUtils.getAllFields(modelClass, (Predicate<Field>) field -> field.getName().equals(fieldName));
        java.lang.reflect.Field field = fieldSet.size() == 1 ? fieldSet.iterator().next() : null;
        PropertyDescriptor propertyDescriptor = null;
        PropertyDescriptor[] props = PropertyUtils.getPropertyDescriptors(modelClass);
        for (PropertyDescriptor prop : props) {
            if(prop.getName().equals(fieldName)) {
                propertyDescriptor = prop;
            }
        }
        if(field == null && propertyDescriptor == null) {
            throw new IllegalArgumentException("field " + fieldName + " not found in model class " + modelClass);
        }
        return new AttributeDescriptor(field, propertyDescriptor);
    }

    public static Object getAttributeValue(final String fieldName, Object modelInstance) {
        Object value = modelInstance;
        for (StringTokenizer tt = new StringTokenizer(fieldName, "."); tt.hasMoreTokens(); ) {
            if (value == null){
                return null;
            }
            String subPath = tt.nextToken();
            AttributeDescriptor descriptor = getAttributeDescriptor(subPath, value.getClass());
            value = descriptor.getValue(value);
        }
        return value;
    }
}
