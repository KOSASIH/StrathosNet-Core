package core.AIAlgorithms;

import utils.Logger;

import java.util.HashMap;
import java.util.Map;

public class TrafficAnalyzer {
    private Map<String, Integer> trafficData;

    public TrafficAnalyzer() {
        trafficData = new HashMap<>();
    }

    public void logTraffic(String deviceId, int dataUsage) {
        trafficData.put(deviceId, trafficData.getOrDefault(deviceId, 0) + dataUsage);
        Logger.log("Logged " + dataUsage + " MB of traffic for device: " + deviceId);
    }

    public void analyzeTrafficPatterns() {
        // Logic to analyze traffic patterns and detect anomalies
        Logger.log("Analyzing traffic patterns...");
        for (Map.Entry<String, Integer> entry : trafficData.entrySet()) {
            if (entry.getValue() > 1000) { // Example threshold
                Logger.log("High traffic detected for device: " + entry.getKey());
            }
        }
    }
}
