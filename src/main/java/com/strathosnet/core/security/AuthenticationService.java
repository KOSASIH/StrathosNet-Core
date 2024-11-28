package core.Security;

import core.UserManager;
import utils.Logger;

public class AuthenticationService {
    private UserManager userManager;

    public AuthenticationService(UserManager userManager) {
        this.userManager = userManager;
    }

    public boolean authenticate(String username, String password) {
        boolean isAuthenticated = userManager.authenticateUser (username, password);
        if (isAuthenticated) {
            Logger.log("User  " + username + " authenticated successfully.");
        } else {
            Logger.log("Authentication failed for user: " + username);
        }
        return isAuthenticated;
    }

    public void registerUser (String username, String password) {
        userManager.addUser (username, password);
        Logger.log("User  " + username + " registered successfully.");
    }
}
