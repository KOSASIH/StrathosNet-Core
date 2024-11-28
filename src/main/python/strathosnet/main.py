import logging
from strathosnet.data_processing import DataProcessor
from strathosnet.api_client import APIClient
from strathosnet.machine_learning import MachineLearningModel

# Configure logging
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')

def main():
    # Data Processing
    processor = DataProcessor('config/data_processing_config.json')
    raw_data = processor.load_data('data/raw_data.csv')
    processor.save_data(raw_data, 'data/processed_data.csv')

    # API Client
    client = APIClient('https://api.strathosnet.com', 'your_api_key')
    user_data = client.get('users/1')
    logging.info(f"Fetched user data: {user_data}")

    # Machine Learning
    ml_model = MachineLearningModel('models/random_forest_model.pkl')
    ml_model.train(raw_data, target_column='target')
    ml_model.save_model()

if __name__ == "__main__":
    main()
