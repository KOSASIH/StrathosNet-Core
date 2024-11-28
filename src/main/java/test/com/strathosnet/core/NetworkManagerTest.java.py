package com.strathosnet.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NetworkManagerTest {
    private NetworkManager networkManager;

    @BeforeEach
    public void setUp() {
        networkManager = new NetworkManager();
    }

    @Test
    public void testConnect() {
        boolean result = networkManager.connect("satellite1");
        assertTrue(result, "Should connect to the satellite successfully");
    }

    @Test
    public void testDisconnect() {
        networkManager.connect("satellite1");
        boolean result = networkManager.disconnect("satellite1");
        assertTrue(result, "Should disconnect from the satellite successfully");
    }

    @Test
    public void testGetStatus() {
        networkManager.connect("satellite1");
        String status = networkManager.getStatus("satellite1");
        assertEquals("Connected", status, "Status should be 'Connected'");
    }
}
