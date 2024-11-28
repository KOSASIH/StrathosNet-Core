package core.Security;

import utils.Logger;

import java.util.HashSet;
import java.util.Set;

public class FirewallManager {
    private Set<String> allowedIPs;
    private Set<String> blockedIPs;

    public FirewallManager() {
        allowedIPs = new HashSet<>();
        blockedIPs = new HashSet<>();
    }

    public void allowIP(String ip) {
        allowedIPs.add(ip);
        Logger.log("IP allowed: " + ip);
    }

    public void blockIP(String ip) {
        blockedIPs.add(ip);
        Logger.log("IP blocked: " + ip);
    }

    public boolean isAllowed(String ip) {
        if (blockedIPs.contains(ip)) {
            Logger.log("Access denied for IP: " + ip);
            return false;
        }
        Logger.log("Access granted for IP: " + ip);
        return allowedIPs.contains(ip);
    }
}
