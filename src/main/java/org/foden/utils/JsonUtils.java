package org.foden.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.foden.constants.FrameworkConstants;
import org.foden.enums.ConfigProperties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class JsonUtils {
    private static Map<String, String> CONFIGMAP;
    private JsonUtils(){}
    static {
        try{
            CONFIGMAP =  new ObjectMapper().readValue(new File(FrameworkConstants.getJsonfilepath()), new TypeReference<Map<String, String>>() {});
        }
        catch (IOException e){
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * Get string.
     *
     * @param key the key
     * @return the string
     */
    public static String get(ConfigProperties key){
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))){
            try {
                throw new Exception("Property name: " + key + " was not found. Please check config.properties");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }
}
