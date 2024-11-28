package com.strathosnet.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConfigLoaderTest {
    private ConfigLoader configLoader;

    @BeforeEach
    public void setUp() {
        configLoader = new ConfigLoader("resources/test_data.json");
    }

    @Test
    public void testLoadConfig() {
        Map<String, String> config = configLoader.load();
        assertNotNull(config, "Config should not be null");
        assertTrue(config.containsKey("key1"), "Config should contain key1");
    }

    @Test
    public void testLoadInvalidConfig() {
        ConfigLoader invalidLoader = new ConfigLoader("resources/invalid.json");
        assertThrows(FileNotFoundException.class, () -> {
            invalidLoader.load();
        }, "Should throw FileNotFoundException for invalid config file");
    }
}
