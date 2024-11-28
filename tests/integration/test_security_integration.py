import unittest
from src.main.java.com.strathosnet.core.Security.AuthenticationService import AuthenticationService

class TestSecurityIntegration(unittest.TestCase):

    def setUp(self):
        self.auth_service = AuthenticationService()

    def test_user_authentication(self):
        result = self.auth_service.authenticate("admin", "password123")
        self.assertTrue(result, "User  should be authenticated successfully.")

    def test_failed_authentication(self):
        result = self.auth_service.authenticate("admin", "wrongpassword")
        self.assertFalse(result, "Authentication should fail with wrong password.")

    def test_access_control(self):
        has_access = self.auth_service.check_access("admin", "delete")
        self.assertTrue(has_access, "Admin should have delete access.")

if __name__ == '__main__':
    unittest.main()
