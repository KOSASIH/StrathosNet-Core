import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import accuracy_score
import logging
import joblib

# Configure logging
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')

class MachineLearningModel:
    def __init__(self, model_path):
        self.model_path = model_path
        self.model = None

    def train(self, data, target_column):
        logging.info("Training machine learning model...")
        X = data.drop(columns=[target_column])
        y = data[target_column]
        X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

        self.model = RandomForestClassifier(n_estimators=100, random_state=42)
        self.model.fit(X_train, y_train)

        predictions = self.model.predict(X_test)
        accuracy = accuracy_score(y_test, predictions)
        logging.info(f"Model trained with accuracy: {accuracy:.2f}")

    def save_model(self):
        logging.info(f"Saving model to {self.model_path}...")
        joblib.dump(self.model, self.model_path)

    def load_model(self):
        logging.info(f"Loading model from {self.model_path}...")
        self.model = joblib.load(self.model_path)

    def predict(self, data):
        logging.info("Making predictions...")
        return self.model.predict(data)

#```python
# Example usage
if __name__ == "__main__":
    data = pd.read_csv('data/processed_data.csv')
    ml_model = MachineLearningModel('models/random_forest_model.pkl')
    ml_model.train(data, target_column='target')
    ml_model.save_model()
