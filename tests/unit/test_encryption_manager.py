import unittest
from src.main.java.com.strathosnet.core.EncryptionManager import EncryptionManager

class TestEncryptionManager(unittest.TestCase):

    def setUp(self):
        self.encryption_manager = EncryptionManager()

    def test_encrypt(self):
        plaintext = "Hello, World!"
        ciphertext = self.encryption_manager.encrypt(plaintext)
        self.assertNotEqual(plaintext, ciphertext, "Ciphertext should not equal plaintext.")

    def test_decrypt(self):
        plaintext = "Hello, World!"
        ciphertext = self.encryption_manager.encrypt(plaintext)
        decrypted_text = self.encryption_manager.decrypt(ciphertext)
        self.assertEqual(plaintext, decrypted_text, "Decrypted text should match plaintext.")

if __name__ == '__main__':
    unittest.main()
