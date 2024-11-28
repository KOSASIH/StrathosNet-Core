import unittest
from src.main.java.com.strathosnet.core.NetworkManager import NetworkManager

class TestNetworkIntegration(unittest.TestCase):

    def setUp(self):
        self.network_manager = NetworkManager()

    def test_network_connection(self):
        result = self.network_manager.connect()
        self.assertTrue(result, "Network connection should be successful.")

    def test_data_transfer(self):
        data = "Test data"
        result = self.network_manager.send_data(data)
        self.assertTrue(result, "Data transfer should be successful.")

    def test_network_status(self):
        status = self.network_manager.get_status()
        self.assertEqual(status, "Connected", "Network status should be 'Connected'.")

if __name__ == '__main__':
    unittest.main()
