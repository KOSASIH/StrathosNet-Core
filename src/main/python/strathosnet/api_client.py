import requests
import logging

# Configure logging
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')

class APIClient:
    def __init__(self, base_url, api_key):
        self.base_url = base_url
        self.api_key = api_key

    def get_headers(self):
        return {
            'Authorization': f'Bearer {self.api_key}',
            'Content-Type': 'application/json'
        }

    def get(self, endpoint):
        url = f"{self.base_url}/{endpoint}"
        logging.info(f"Making GET request to {url}...")
        response = requests.get(url, headers=self.get_headers())
        response.raise_for_status()
        return response.json()

    def post(self, endpoint, data):
        url = f"{self.base_url}/{endpoint}"
        logging.info(f"Making POST request to {url} with data: {data}...")
        response = requests.post(url, json=data, headers=self.get_headers())
        response.raise_for_status()
        return response.json()

# Example usage
if __name__ == "__main__":
    client = APIClient('https://api.strathosnet.com', 'your_api_key')
    user_data = client.get('users/1')
    print(user_data)
