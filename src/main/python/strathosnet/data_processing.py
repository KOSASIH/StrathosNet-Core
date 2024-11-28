import pandas as pd
import numpy as np
import json
import logging

# Configure logging
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')

class DataProcessor:
    def __init__(self, config_path):
        self.config = self.load_config(config_path)

    def load_config(self, path):
        with open(path, 'r') as file:
            return json.load(file)

    def clean_data(self, df):
        logging.info("Cleaning data...")
        # Remove duplicates
        df = df.drop_duplicates()
        # Fill missing values
        df.fillna(method='ffill', inplace=True)
        return df

    def transform_data(self, df):
        logging.info("Transforming data...")
        # Example transformation: Normalizing numerical features
        numerical_cols = df.select_dtypes(include=[np.number]).columns.tolist()
        df[numerical_cols] = (df[numerical_cols] - df[numerical_cols].mean()) / df[numerical_cols].std()
        return df

    def load_data(self, file_path):
        logging.info(f"Loading data from {file_path}...")
        df = pd.read_csv(file_path)
        df = self.clean_data(df)
        df = self.transform_data(df)
        return df

    def save_data(self, df, output_path):
        logging.info(f"Saving processed data to {output_path}...")
        df.to_csv(output_path, index=False)

# Example usage
if __name__ == "__main__":
    processor = DataProcessor('config/data_processing_config.json')
    data = processor.load_data('data/raw_data.csv')
    processor.save_data(data, 'data/processed_data.csv')
