package core;

import models.User;
import utils.EncryptionUtil;
import utils.Logger;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, User> users;

    public UserManager() {
        users = new HashMap<>();
    }

    public void addUser (String username, String password) {
        String encryptedPassword = EncryptionUtil.encrypt(password);
        users.put(username, new User(username, encryptedPassword));
        Logger.log("User  added: " + username);
    }

    public boolean authenticateUser (String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(EncryptionUtil.encrypt(password));
    }

    public void removeUser (String username) {
        users.remove(username);
        Logger.log("User  removed: " + username);
    }
}
