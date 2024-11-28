package core;

import utils.Logger;

import java.util.HashMap;
import java.util.Map;

public class DataRouter {
    private Map<String, String> routingTable;

    public DataRouter() {
        routingTable = new HashMap<>();
    }

    public void addRoute(String destination, String nextHop) {
        routingTable.put(destination, nextHop);
        Logger.log("Route added: " + destination + " via " + nextHop);
    }

    public String getNextHop(String destination) {
        return routingTable.get(destination);
    }

    public void removeRoute(String destination) {
        routingTable.remove(destination);
        Logger.log("Route removed: " + destination);
    }
}
