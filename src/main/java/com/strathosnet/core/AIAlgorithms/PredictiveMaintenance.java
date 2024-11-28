package core.AIAlgorithms;

import utils.Logger;

import java.util.HashMap;
import java.util.Map;

public class PredictiveMaintenance {
    private Map<String, Integer> deviceHealthMetrics;

    public PredictiveMaintenance() {
        deviceHealthMetrics = new HashMap<>();
    }

    public void updateHealthMetric(String deviceId, int healthScore) {
        deviceHealthMetrics.put(deviceId, healthScore);
        Logger.log("Updated health metric for device: " + deviceId + " to " + healthScore);
    }

    public void predictFailures() {
        // Logic to predict device failures based on health metrics
        Logger.log("Predicting device failures...");
        for (Map.Entry<String, Integer> entry : deviceHealthMetrics.entrySet()) {
            if (entry.getValue() < 50) { // Example threshold
                Logger.log("Warning: Device " + entry.getKey() + " may fail soon.");
            }
        }
    }
}
