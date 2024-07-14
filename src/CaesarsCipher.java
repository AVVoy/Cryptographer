import java.util.Arrays;

public class CaesarsCipher {

    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};
    private static final int ALPHABET_LENGTH = ALPHABET.length;

    public static char[] getAlphabet() {
        return Arrays.copyOf(ALPHABET, ALPHABET_LENGTH);
    }

    public String encrypt(String text, int shift) {

        // Логика шифрования
        StringBuilder out = new StringBuilder();
        for(char ch : text.toCharArray()) {
            if (!isContainedInALPHABET(ch)) {
                out.append(ch);
            } else {
                int index = getIndexOfChInALPHABET(ch) + shift;
                if (index >= ALPHABET_LENGTH) {
                    index -= ALPHABET_LENGTH;
                }
                if (index < 0) {
                    index += ALPHABET_LENGTH;
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

    private int getIndexOfChInALPHABET(char ch) {
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

    private boolean isContainedInALPHABET(char ch) {
        for (char character : ALPHABET) {
            if (ch == character) {
                return true;
            }
        }
        return false;
    }

}
