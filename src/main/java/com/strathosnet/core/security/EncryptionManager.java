package core.Security;

import utils.EncryptionUtil;
import utils.Logger;

public class EncryptionManager {
    public String encryptData(String data) {
        String encryptedData = EncryptionUtil.encrypt(data);
        Logger.log("Data encrypted.");
        return encryptedData;
    }

    public String decryptData(String encryptedData) {
        // For demonstration, we will assume symmetric encryption
        // In practice, you would use a proper decryption method
        Logger.log("Data decrypted.");
        return encryptedData; // Placeholder: Implement actual decryption logic
    }
}
