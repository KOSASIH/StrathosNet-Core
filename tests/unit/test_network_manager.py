import unittest
from src.main.java.com.strathosnet.core.NetworkManager import NetworkManager

class TestNetworkManager(unittest.TestCase):

    def setUp(self):
        self.network_manager = NetworkManager()

    def test_initialization(self):
        self.assertIsNotNone(self.network_manager, "NetworkManager should be initialized.")

    def test_connect(self):
        result = self.network_manager.connect()
        self.assertTrue(result, "NetworkManager should connect successfully.")

    def test_disconnect(self):
        self.network_manager.connect()  # Ensure it's connected first
        result = self.network_manager.disconnect()
        self.assertTrue(result, "NetworkManager should disconnect successfully.")

if __name__ == '__main__':
    unittest.main()
