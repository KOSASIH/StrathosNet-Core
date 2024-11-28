package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private Properties properties;

    public ConfigLoader(String configFilePath) {
        properties = new Properties();
        loadConfig(configFilePath);
    }

    private void loadConfig(String configFilePath) {
        try (FileInputStream input = new FileInputStream(configFilePath)) {
            properties.load(input);
            Logger.log("Configuration loaded from " + configFilePath);
        } catch (IOException e) {
            Logger.log("Error loading configuration: " + e.getMessage());
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public int getIntProperty(String key, int defaultValue) {
        String value = properties.getProperty(key);
        return value != null ? Integer.parseInt(value) : defaultValue;
    }

    public boolean getBooleanProperty(String key, boolean defaultValue) {
        String value = properties.getProperty(key);
        return value != null ? Boolean.parseBoolean(value) : defaultValue;
    }
}
