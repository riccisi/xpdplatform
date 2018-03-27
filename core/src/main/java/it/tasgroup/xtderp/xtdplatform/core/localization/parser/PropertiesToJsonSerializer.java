package it.tasgroup.xtderp.xtdplatform.core.localization.parser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesToJsonSerializer  extends JsonSerializer<Properties> {

    @Override
    public void serialize(Properties properties,
                          JsonGenerator jgen,
                          SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        Map hierarchicalMap = this.buildHierarchicalMapFromFlatProperties(properties);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(jgen, hierarchicalMap);
    }

    private Map buildHierarchicalMapFromFlatProperties(Properties properties) {
        Map hierarchicalMap = new HashMap();
        for (final String key: properties.stringPropertyNames()) {
            createFromBundleKey(hierarchicalMap, key, properties.getProperty(key));
        }
        return hierarchicalMap;
    }

    private Map createFromBundleKey(final Map prop, final String key, final String value) {
        if (!key.contains(".")) {
            final Map childProp = getChildMapIfExists(prop, key);
            childProp.put("text", value);
            prop.put(key, childProp);
            return prop;
        }

        final String currentKey = firstKey(key);
        if (currentKey != null) {
            final String subRightKey = key.substring(currentKey.length() + 1, key.length());
            final Map childProp = getChildMapIfExists(prop, currentKey);
            prop.put(currentKey, createFromBundleKey(childProp, subRightKey, value));
        }

        return prop;
    }

    private String firstKey(final String fullKey) {
        final String[] splittedKey = fullKey.split("\\.");
        return (splittedKey.length != 0) ? splittedKey[0] : fullKey;
    }

    private Map getChildMapIfExists(final Map prop, final String key) {
        if (prop == null) {
            return null;
        }
        if (prop.containsKey(key)) {
            return (Map) prop.get(key);
        } else {
            return new HashMap();
        }
    }
}
