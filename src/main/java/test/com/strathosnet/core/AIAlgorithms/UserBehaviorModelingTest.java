package com.strathosnet.core.AIAlgorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserBehaviorModelingTest {
    private UserBehaviorModeling userBehaviorModeling;

    @BeforeEach
    public void setUp() {
        userBehaviorModeling = new UserBehaviorModeling();
    }

    @Test
    public void test ModelUser Behavior() {
        String behavior = userBehaviorModeling.model(new User("user1", "activity1"));
        assertEquals("ExpectedBehavior", behavior, "Should model user behavior correctly");
    }

    @Test
    public void testModelMultipleUsers() {
        List<User> users = Arrays.asList(new User("user1", "activity1"), new User("user2", "activity2"));
        Map<String, String> behaviors = userBehaviorModeling.modelMultiple(users);
        assertEquals(2, behaviors.size(), "Should model behaviors for multiple users");
    }
}
