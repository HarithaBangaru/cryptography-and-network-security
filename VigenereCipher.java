import java.util.*;

public class VigenereCipher {
    public static String key = new String();
    public String extndkey;
    public String plaintxt, ciphertxt;
    public String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int row, flag = 0, decrypt = 0;

    public String keyExtension(String plaintext, String keyText) {
        int i, j = 0;
        String newKey = "";
        for (i = 0; i < plaintext.length(); i++) {
            newKey += keyText.charAt(j);
            j++;
            if (j == keyText.length())
                j = 0;
        }
        return newKey;
    }

    public int valueOfChar(char x) {
        int i, pos = 0;
        for (i = 0; i < 26; i++) {
            if (x == ALPHABET.charAt(i)) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public char charOfValue(int y) {
        return ALPHABET.charAt(y);
    }

    public String vigenereEncryption(String text) {
        int i, p = 0, k = 0, tmp1 = 0;
        char tmp;
        String ciphertext = "";
        extndkey = keyExtension(text, key);
        System.out.println("VIGENERE ENCRYPTION");
        System.out.println("PLAIN TEXT : " + text);
        System.out.println("VIGENERE KEY : " + extndkey);
        for (i = 0; i < text.length(); i++) {
            p = valueOfChar(text.charAt(i));
            k = valueOfChar(extndkey.charAt(i));
            tmp1 = (p + k) % 26;
            tmp = charOfValue(tmp1);
            ciphertext += tmp;
        }
        return ciphertext;
    }

    public String vigenereDecryption(String text) {
        int i, c = 0, k = 0, tmp1 = 0;
        char ch;
        String plaintext = "";
        System.out.println("VIGENERE DECRYPTION");
        System.out.println("CIPHER TEXT : " + text);
        System.out.println("VIGENERE KEY : " + extndkey);
        for (i = 0; i < text.length(); i++) {
            c = valueOfChar(text.charAt(i));
            k = valueOfChar(extndkey.charAt(i));
            tmp1 = (c - k + 26) % 26;
            ch = charOfValue(tmp1);
            plaintext += ch;
        }
        return plaintext;
    }

    public static void main(String[] args) {
        VigenereCipher vc = new VigenereCipher();
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER KEY");
        key = sc.next();
        String text = new String();
        System.out.println("Enter PLAIN TEXT");
        text = sc.next();
        String ciphertext = new String();
        ciphertext = vc.vigenereEncryption(text);
        System.out.println();
        System.out.println("CIPHER TEXT: " + ciphertext);
        System.out.println();
        String plaintext = new String();
        plaintext = vc.vigenereDecryption(ciphertext);
        System.out.println();
        System.out.println("PLAIN TEXT: " + plaintext);
        sc.close();
    }
}
