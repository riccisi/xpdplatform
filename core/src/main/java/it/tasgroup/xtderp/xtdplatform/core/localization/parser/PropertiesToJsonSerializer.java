package it.tasgroup.xtderp.xtdplatform.core.localization.parser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class PropertiesToJsonSerializer extends JsonSerializer<Properties> {

    @Override
    public void serialize(final Properties properties,
                          final JsonGenerator jgen,
                          final SerializerProvider serializerProvider) throws IOException {
        final Map map = this.buildHierarchicalMapFromFlatProperties(properties);
        final ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(jgen, map);
    }

    private Map buildHierarchicalMapFromFlatProperties(final Properties properties) {
        final Map map = new HashMap();
        for (final String key: properties.stringPropertyNames()) {
            this.createFromBundleKey(map, key, properties.getProperty(key));
        }
        return map;
    }

    private Map createFromBundleKey(final Map prop, final String key, final String value) {
        if (!key.contains(".")) {
            final Map childProp = this.getChildMapIfExists(prop, key);
            childProp.put("text", value);
            prop.put(key, childProp);
            return prop;
        }

        final String currentKey = this.firstKey(key);
        if (currentKey != null) {
            final String subRightKey = key.substring(currentKey.length() + 1, key.length());
            final Map childProp = this.getChildMapIfExists(prop, currentKey);
            prop.put(currentKey, this.createFromBundleKey(childProp, subRightKey, value));
        }

        return prop;
    }

    private String firstKey(final String fullKey) {
        final String[] splittedKey = fullKey.split("\\.");
        return splittedKey.length != 0 ? splittedKey[0] : fullKey;
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
