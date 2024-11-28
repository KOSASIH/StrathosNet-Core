import unittest
import pandas as pd
import os
from strathosnet.data_processing import DataProcessor

class TestDataProcessor(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        # Create a sample CSV file for testing
        cls.test_csv_path = 'test_data.csv'
        cls.test_data = pd.DataFrame({
            'feature1': [1, 2, 2, 3, None],
            'feature2': [5, 6, 6, None, 8],
            'target': [0, 1, 1, 0, 1]
        })
        cls.test_data.to_csv(cls.test_csv_path, index=False)

        # Initialize DataProcessor
        cls.processor = DataProcessor('config/data_processing_config.json')

    @classmethod
    def tearDownClass(cls):
        # Remove the test CSV file after tests
        if os.path.exists(cls.test_csv_path):
            os.remove(cls.test_csv_path)

    def test_load_data(self):
        df = self.processor.load_data(self.test_csv_path)
        self.assertEqual(df.shape[0], 4)  # Check for duplicates removal
        self.assertFalse(df['feature1'].isnull().any())  # Check for NaN handling

    def test_clean_data(self):
        df = self.processor.clean_data(self.test_data)
        self.assertEqual(df.shape[0], 4)  # Check for duplicates removal
        self.assertFalse(df['feature1'].isnull().any())  # Check for NaN handling

    def test_transform_data(self):
        df = self.processor.transform_data(self.test_data)
        self.assertAlmostEqual(df['feature1'].mean(), 0, delta=0.1)  # Check normalization

if __name__ == '__main__':
    unittest.main()
