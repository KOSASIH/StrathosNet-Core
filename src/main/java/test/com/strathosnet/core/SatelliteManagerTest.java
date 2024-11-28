package com.strathosnet.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SatelliteManagerTest {
    private SatelliteManager satelliteManager;

    @BeforeEach
    public void setUp() {
        satelliteManager = new SatelliteManager();
    }

    @Test
    public void testAddSatellite() {
        Satellite satellite = new Satellite("satellite1");
        satelliteManager.addSatellite(satellite);
        assertEquals(1, satelliteManager.getSatelliteCount(), "Should have one satellite");
    }

    @Test
    public void testRemoveSatellite() {
        Satellite satellite = new Satellite("satellite1");
        satelliteManager.addSatellite(satellite);
        satelliteManager.removeSatellite("satellite1");
        assertEquals(0, satelliteManager.getSatelliteCount(), "Should have no satellites");
    }

    @Test
    public void testGetSatellite() {
        Satellite satellite = new Satellite("satellite1");
        satelliteManager.addSatellite(satellite);
        Satellite retrieved = satelliteManager.getSatellite("satellite1");
        assertNotNull(retrieved, "Should retrieve the satellite");
        assertEquals("satellite1", retrieved.getName(), "Satellite name should match");
    }
}
