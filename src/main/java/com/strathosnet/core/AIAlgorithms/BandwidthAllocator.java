package core.AIAlgorithms;

import utils.Logger;

import java.util.HashMap;
import java.util.Map;

public class BandwidthAllocator {
    private Map<String, Integer> bandwidthAllocation;

    public BandwidthAllocator() {
        bandwidthAllocation = new HashMap<>();
    }

    public void allocateBandwidth(String deviceId, int bandwidth) {
        bandwidthAllocation.put(deviceId, bandwidth);
        Logger.log("Allocated " + bandwidth + " Mbps to device: " + deviceId);
    }

    public void optimizeBandwidth() {
        // Logic to optimize bandwidth allocation based on usage patterns
        Logger.log("Optimizing bandwidth allocation...");
        // Example: Reallocate bandwidth based on device priority or usage
    }

    public int getAllocatedBandwidth(String deviceId) {
        return bandwidthAllocation.getOrDefault(deviceId, 0);
    }
}
