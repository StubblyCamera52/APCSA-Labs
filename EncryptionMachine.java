import java.nio.charset.StandardCharsets;
import java.util.HexFormat;

public class EncryptionMachine {

    public static void main(String[] args) {
        String m = encrypt("lllllll", "message");
        System.out.println(m);
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
}
