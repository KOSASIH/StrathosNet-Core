import unittest
from unittest.mock import patch, Mock
from strathosnet.api_client import APIClient

class TestAPIClient(unittest.TestCase):
    def setUp(self):
        self.client = APIClient('https://api.strathosnet.com', 'test_api_key')

    @patch('requests.get')
    def test_get(self, mock_get):
        # Mock the response
        mock_response = Mock()
        mock_response.json.return_value = {'id': 1, 'name': 'Test User'}
        mock_response.status_code = 200
        mock_get.return_value = mock_response

        response = self.client.get('users/1')
        self.assertEqual(response['id'], 1)
        self.assertEqual(response['name'], 'Test User')
        mock_get.assert_called_once_with('https://api.strathosnet.com/users/1', headers=self.client.get_headers())

    @patch('requests.post')
    def test_post(self, mock_post):
        # Mock the response
        mock_response = Mock()
        mock_response.json.return_value = {'success': True}
        mock_response.status_code = 200
        mock_post.return_value = mock_response

        response = self.client.post('users', {'name': 'New User'})
        self.assertTrue(response['success'])
        mock_post.assert_called_once_with('https://api.strathosnet.com/users', json={'name': 'New User'}, headers=self.client.get_headers())

if __name__ == '__main__':
    unittest.main()
