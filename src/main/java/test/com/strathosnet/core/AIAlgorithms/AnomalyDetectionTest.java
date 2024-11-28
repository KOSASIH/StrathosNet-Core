package com.strathosnet.core.AIAlgorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnomalyDetectionTest {
    private AnomalyDetection anomalyDetection;

    @BeforeEach
    public void setUp() {
        anomalyDetection = new AnomalyDetection();
    }

    @Test
    public void testDetectAnomaly() {
        boolean result = anomalyDetection.detect(new double[]{1.0, 2.0, 3.0});
        assertFalse(result, "Should not detect anomaly in normal data");
    }

    @Test
    public void testDetectAnomalyWithOutlier() {
        boolean result = anomalyDetection.detect(new double[]{1.0, 2.0, 100.0});
        assertTrue(result, "Should detect anomaly with outlier data");
    }
}
