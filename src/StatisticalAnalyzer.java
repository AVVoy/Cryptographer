import java.util.HashMap;

public class StatisticalAnalyzer {
    public int findMostLikelyShift(String encryptedText, char[] alphabet, String representativeText) {

        HashMap<Character, Double> frequencyOfOccurrenceOfSymbolInRepresentativeText =
                getFrequencyOfOccurrenceOfSymbol(representativeText, alphabet);

        int shift = Integer.MIN_VALUE;
        double min = Double.MAX_VALUE;

        for (int i = 0; i < alphabet.length; i++) {
            CaesarsCipher cipher = new CaesarsCipher();
            String text = cipher.decrypt(encryptedText, i);
            HashMap<Character, Double> frequencyOfOccurrenceOfSymbolInEncryptedText =
                    getFrequencyOfOccurrenceOfSymbol(text, alphabet);
            double frequencyDeviation = getFrequencyDeviation(
                    frequencyOfOccurrenceOfSymbolInEncryptedText,
                    frequencyOfOccurrenceOfSymbolInRepresentativeText,
                    alphabet);
            if (frequencyDeviation < min) {
                min = frequencyDeviation;
                shift = i;
            }
        }

        return shift;
    }

    private double getFrequencyDeviation(
            HashMap<Character, Double> frequencyOfOccurrenceOfSymbolInEncryptedText,
            HashMap<Character, Double> frequencyOfOccurrenceOfSymbolInRepresentativeText,
            char[] alphabet
    ) {

        double[] frequencyOfOccurrenceOfSymbol =
                new double[frequencyOfOccurrenceOfSymbolInRepresentativeText.size()];

        for (int i = 0; i < alphabet.length; i++) {
            frequencyOfOccurrenceOfSymbol[i] =
                    frequencyOfOccurrenceOfSymbolInRepresentativeText.get(alphabet[i]) -
                            frequencyOfOccurrenceOfSymbolInEncryptedText.get(alphabet[i]);
        }

        double average = getAverage(frequencyOfOccurrenceOfSymbol);

        double sumDifferences = 0;

        for (double frequencyOfOccurrence : frequencyOfOccurrenceOfSymbol) {
            sumDifferences = Math.pow((frequencyOfOccurrence - average),2);
        }

        return Math.sqrt(sumDifferences / frequencyOfOccurrenceOfSymbol.length);
    }

    private double getAverage(double[] valueArray) {
        double frequencyDeviationInText = 0.0;

        for (double value : valueArray) {
            frequencyDeviationInText += value;
        }
        frequencyDeviationInText /= valueArray.length;

        return frequencyDeviationInText;
    }

    private HashMap<Character, Double> getFrequencyOfOccurrenceOfSymbol(String text, char[] alphabet) {
        double numberOfCharInText = text.length();
        HashMap<Character, Double> frequencyOfOccurrenceOfSymbolInText = new HashMap<>();

        for (char c : alphabet) {
            frequencyOfOccurrenceOfSymbolInText.put(c, 0.0);
        }

        for (int i = 0; i < text.length(); i++) {
            for (char c : alphabet) {
                if (text.charAt(i) == c) {
                    frequencyOfOccurrenceOfSymbolInText
                            .put(
                                    c,
                                    frequencyOfOccurrenceOfSymbolInText.get(c) + 1.0
                            );
                }
            }
        }

        frequencyOfOccurrenceOfSymbolInText
                .replaceAll(
                        (c, v) -> v / numberOfCharInText);
        return frequencyOfOccurrenceOfSymbolInText;
    }
}
