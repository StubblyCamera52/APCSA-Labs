// Gavan Bess
// 01/07/2026
// AP CS A
// Lab #4 - Encryption Machine
//
// This program encrypts or decrypts a user message using a ceaser cipher

import java.util.Scanner;

public class EncryptionMachine {

    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final int SHIFT = 3;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome to the AP CS A Encryption Machine!");
        System.out.println("This program lets you encrypt a message");
        System.out.println("with a key so your recipient can decrypt.");
        System.out.println();
        System.out.println(
            "Encrypted messages use a shared keyword to decrypt."
        );
        System.out.print("  Enter key: ");
        String key = s.next();
        System.out.println("    \""+key+"\" has been encrypted to: "+CeaserEncryptWord(key));

        System.out.println();
        System.out.print("How many words are in your message? ");
        int numWords = s.nextInt();

        for (int i = 0; i < numWords; i++) {
            System.out.print("  Next word: ");
            String word = s.next();
            System.out.println("    \""+word+"\" has been encrypted to: "+CeaserEncryptWord(word));
        }

        System.out.println();
        System.out.println("Message fully encrypted. Happy secret messaging!");
        s.close();
    }

    public static char CeaserEncryptCharacter(char c) {
        return ALPHABET.charAt(
            (ALPHABET.indexOf(c) + SHIFT) % ALPHABET.length()
        );
    }

    public static String CeaserEncryptWord(String word) {
        String encryptedWord = "";

        for (int i = 0; i < word.length(); i++) {
            encryptedWord = encryptedWord + CeaserEncryptCharacter(word.charAt(i));
        }

        return encryptedWord;
    }
}
