package utils;

import java.util.HashMap;
import java.util.Map;

public class MetricsCollector {
    private Map<String, Long> metrics;

    public MetricsCollector() {
        metrics = new HashMap<>();
    }

    public void recordMetric(String metricName, long value) {
        metrics.put(metricName, value);
        Logger.log("Recorded metric: " + metricName + " with value: " + value);
    }

    public long getMetric(String metricName) {
        return metrics.getOrDefault(metricName, 0L);
    }

    public void printMetrics() {
        Logger.log("Metrics collected:");
        for (Map.Entry<String, Long> entry : metrics.entrySet()) {
            Logger.log(entry.getKey() + ": " + entry.getValue());
        }
    }
}
