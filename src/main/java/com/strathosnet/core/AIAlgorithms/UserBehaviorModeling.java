package core.AIAlgorithms;

import utils.Logger;

import java.util.HashMap;
import java.util.Map;

public class UserBehaviorModeling {
    private Map<String, Integer> userActivityScores;

    public UserBehaviorModeling() {
        userActivityScores = new HashMap<>();
    }

    public void logUser Activity(String username, int activityScore) {
        userActivityScores.put(username, userActivityScores.getOrDefault(username, 0) + activityScore);
        Logger.log("Logged activity for user: " + username + " with score: " + activityScore);
    }

    public void analyzeUser Behavior() {
        // Logic to analyze user behavior and suggest improvements
        Logger.log("Analyzing user behavior...");
        for (Map.Entry<String, Integer> entry : userActivityScores.entrySet()) {
            if (entry.getValue() > 100) { // Example threshold
                Logger.log("High activity detected for user: " + entry.getKey());
            }
        }
    }
}
