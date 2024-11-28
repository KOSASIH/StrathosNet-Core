package core;

import models.Device;
import utils.Logger;

import java.util.HashMap;
import java.util.Map;

public class SatelliteManager {
    private Map<String, String> satellites;

    public SatelliteManager() {
        satellites = new HashMap<>();
    }

    public void registerSatellite(String satelliteId, String status) {
        satellites.put(satelliteId, status);
        Logger.log("Satellite registered: " + satelliteId + " with status: " + status);
    }

    public void updateSatelliteStatus(String satelliteId, String newStatus) {
        if (satellites.containsKey(satelliteId)) {
            satellites.put(satelliteId, newStatus);
            Logger.log("Satellite status updated: " + satelliteId + " to " + newStatus);
        }
    }

    public String getSatelliteStatus(String satelliteId) {
        return satellites.get(satelliteId);
    }
}
