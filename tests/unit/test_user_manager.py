import unittest
from src.main.java.com.strathosnet.core.UserManager import UserManager

class TestUser Manager(unittest.TestCase):

    def setUp(self):
        self.user_manager = UserManager()

    def test_add_user(self):
        result = self.user_manager.add_user("new_user", "password123")
        self.assertTrue(result, "User  should be added successfully.")

    def test_remove_user(self):
        self.user_manager.add_user("user_to_remove", "password123")
        result = self.user_manager.remove_user("user_to_remove")
        self.assertTrue(result, "User should be removed successfully.")

    def test_get_user(self):
        self.user_manager.add_user("existing_user", "password123")
        user = self.user_manager.get_user("existing_user")
        self.assertIsNotNone(user, "User should be retrieved successfully.")

if __name__ == '__main__':
    unittest.main()
