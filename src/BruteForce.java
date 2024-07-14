import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BruteForce {
    //наиболее часто встречаемые слова в русском языке по версии
    //https://ru.wiktionary.org/wiki/Приложение:Список_частотных_слов_русского_языка_(2013)
    private static final String[] MOST_COMMON_WORDS = {"и", "в", "не", "на", "я", "быть", "с", "он", "что", "а",
            "это", "этот", "по", "к", "но", "они", "мы", "она", "как", "то", "который", "из", "у", "свой", "вы", "весь",
            "за", "для", "от", "мочь", "так", "ты", "о", "человек", "же", "год", "всё", "такой", "тот",
            "или", "если", "только", "его", "один", "бы", "себя", "время", "еще", "другой", "уже"};
    public String decryptByBruteForce(String encryptedText, char[] alphabet) {
        List<Integer> counterMatches = new ArrayList<>(MOST_COMMON_WORDS.length);

        CaesarsCipher cipher = new CaesarsCipher();

        for (int i = 0; i < alphabet.length; i++) {
            int count = 0;
            String decryptedText = cipher.decrypt(encryptedText, i);
            String[] stringsOfDecryptedText = decryptedText.split("\\s");
            for (String str : stringsOfDecryptedText) {
                for (String mostCommonWord : MOST_COMMON_WORDS) {
                    if (str.equals(mostCommonWord)) {
                        count++;
                    }
                }
            }

            counterMatches.add(count);
        }

        int maxCounterMatches = Collections.max(counterMatches);

        return cipher.decrypt(encryptedText, counterMatches.indexOf(maxCounterMatches));
    }


}
