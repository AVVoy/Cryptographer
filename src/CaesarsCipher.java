import java.util.Arrays;

public class CaesarsCipher {

    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};
    private static int alphabetLength = ALPHABET.length;

    public static char[] getAlphabet() {
        return Arrays.copyOf(ALPHABET, alphabetLength);
    }

    public String encrypt(String text, int shift) {
        if (shift >= alphabetLength) {
            shift = shift % alphabetLength;
        }
        if (shift <= -alphabetLength) {
            shift = -(shift % alphabetLength);
        }
        // Логика шифрования
        StringBuilder out = new StringBuilder();
        for(char ch : text.toCharArray()) {
            if (!isContainedInALPHABET(ch)) {
                out.append(ch);
            } else {
                int index = getIndexOfChInALPHABET(ch) + shift;
                if (index >= alphabetLength) {
                    index = index % alphabetLength;
                }
                out.append(ALPHABET[index]);
            }
        }
        return out.toString();

    }

    public String decrypt(String encryptedText, int shift) {
        // Логика расшифровки
        return encrypt(encryptedText, -shift);
    }

    private static int getIndexOfChInALPHABET(char ch) {
        int index = 0;

        for (char character : ALPHABET){
            if (ch == character) {
                return index;
            } else {
                index++;
            }
        }

        return index;
    }

    private static boolean isContainedInALPHABET(char ch) {
        for (char character : ALPHABET) {
            if (ch == character) {
                return true;
            }
        }
        return false;
    }

}
