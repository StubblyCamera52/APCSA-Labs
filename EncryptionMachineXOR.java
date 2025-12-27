// Gavan Bess
// 12/18/2025
// AP CS A
// Lab #4 - Encryption Machine
//
// This program encrypts or decrypts a user message using a user provided encryption/decryption key

import java.nio.charset.StandardCharsets;
import java.util.HexFormat;

public class EncryptionMachine {

    public static void main(String[] args) {
        String m = encrypt("message", "message");
        System.out.println(m);
        System.out.println(decrypt("message", m));
    }

    public static String encrypt(String key, String message) {
        String encryptedMessage = "";
        byte[] asciiMessage = message.getBytes(StandardCharsets.US_ASCII);
        byte[] asciiKey = key.getBytes(StandardCharsets.US_ASCII);

        for (int i = 0; i < asciiMessage.length; i++) {
            byte messageByte = asciiMessage[i];
            byte keyByte = asciiKey[i % asciiKey.length];

            int result = (messageByte ^ keyByte);

            encryptedMessage = encryptedMessage.concat(HexFormat.of().formatHex(new byte[] { (byte) result }));
        }

        return encryptedMessage;
    }

    public static String decrypt(String key, String message) {
        String decoded_message = new String(HexFormat.of().parseHex(message), StandardCharsets.US_ASCII);
        String decrypted_message = encrypt(key, decoded_message);

        return new String(HexFormat.of().parseHex(decrypted_message), StandardCharsets.US_ASCII);
    }
}
