package core;

import models.Device;
import utils.Logger;

import java.util.ArrayList;
import java.util.List;

public class NetworkManager {
    private List<Device> connectedDevices;

    public NetworkManager() {
        connectedDevices = new ArrayList<>();
    }

    public void initializeNetwork() {
        Logger.log("Initializing network...");
        // Logic to initialize network connections
    }

    public void addDevice(Device device) {
        connectedDevices.add(device);
        Logger.log("Device added: " + device.getId());
    }

    public void removeDevice(String deviceId) {
        connectedDevices.removeIf(device -> device.getId().equals(deviceId));
        Logger.log("Device removed: " + deviceId);
    }

    public List<Device> getConnectedDevices() {
        return connectedDevices;
    }

    public void monitorNetwork() {
        // Logic to monitor network performance and health
        Logger.log("Monitoring network...");
    }
}
