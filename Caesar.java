import java.io.*;

public class Caesar {
    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static String encrypt(String plaintext, int cipherKey) {
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char currentChar = plaintext.charAt(i);
            if (Character.isLetter(currentChar)) {
                int plainNumeric = ALPHABET.indexOf(Character.toUpperCase(currentChar));
                int cipherNumeric = (plainNumeric + cipherKey) % ALPHABET.length();
                char cipherChar = ALPHABET.charAt(cipherNumeric);
                if (Character.isLowerCase(currentChar)) 
                    ciphertext.append(Character.toLowerCase(cipherChar));
                 else 
                    ciphertext.append(cipherChar);
            } else 
                ciphertext.append(currentChar); 
        }
        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int cipherKey) {
        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            char currentChar = ciphertext.charAt(i);
            if (Character.isLetter(currentChar)) {
                int cipherNumeric = ALPHABET.indexOf(Character.toUpperCase(currentChar));
                int plainNumeric = (cipherNumeric - cipherKey + ALPHABET.length()) % ALPHABET.length();
                char plainChar = ALPHABET.charAt(plainNumeric);
                if (Character.isLowerCase(currentChar)) 
                    plaintext.append(Character.toLowerCase(plainChar));
                 else 
                    plaintext.append(plainChar);
            } else 
                plaintext.append(currentChar);  
        }
        return plaintext.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the PLAIN TEXT for Encryption: ");
        String plaintext = br.readLine();
        
        System.out.println("Enter the CAESAR KEY between 0 and 25:");
        int cipherKey = Integer.parseInt(br.readLine());

        System.out.println("ENCRYPTION");
        String ciphertext = encrypt(plaintext, cipherKey);
        System.out.println("CIPHER TEXT: " + ciphertext);

        System.out.println("DECRYPTION");
        plaintext = decrypt(ciphertext, cipherKey);
        System.out.println("PLAIN TEXT: " + plaintext);
    }
}
