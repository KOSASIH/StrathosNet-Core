import unittest
from src.main.java.com.strathosnet.core.SatelliteManager import SatelliteManager

class TestSatelliteIntegration(unittest.TestCase):

    def setUp(self):
        self.satellite_manager = SatelliteManager()

    def test_satellite_activation(self):
        result = self.satellite_manager.activate_satellite("SAT-001")
        self.assertTrue(result, "Satellite should be activated successfully.")

    def test_image_capture(self):
        result = self.satellite_manager.capture_image("SAT-001")
        self.assertIsNotNone(result, "Captured image should not be None.")

    def test_satellite_status(self):
        status = self.satellite_manager.get_satellite_status("SAT-001")
        self.assertEqual(status, "Active", "Satellite status should be 'Active'.")

if __name__ == '__main__':
    unittest.main()
