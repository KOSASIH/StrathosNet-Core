package core.AIAlgorithms;

import utils.Logger;

import java.util.HashMap;
import java.util.Map;

public class AnomalyDetection {
    private Map<String, Integer> normalUsagePatterns;

    public AnomalyDetection() {
        normalUsagePatterns = new HashMap<>();
    }

    public void setNormalUsage(String deviceId, int normalUsage) {
        normalUsagePatterns.put(deviceId, normalUsage);
        Logger.log("Set normal usage for device: " + deviceId + " to " + normalUsage);
    }

    public void detectAnomalies(String deviceId, int currentUsage) {
        int normalUsage = normalUsagePatterns.getOrDefault(deviceId, 0);
        if (currentUsage > normalUsage * 1.5) { // Example anomaly threshold
            Logger.log("Anomaly detected for device: " + deviceId + ". Current usage: " + currentUsage);
        }
    ```java
    }
}
