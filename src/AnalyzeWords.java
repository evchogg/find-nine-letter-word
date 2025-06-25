import java.util.Set;

public class AnalyzeWords {


    public static boolean analyze(String word, Set<String> englishDictionary) {
        StringBuilder tempStringBuffer = new StringBuilder(word);
        String tempWord;
        for (int i = 0; i <= word.length() - 1; i++) {
            tempStringBuffer.deleteCharAt(i);
            tempWord = tempStringBuffer.toString();
            if (englishDictionary.contains(tempWord) || tempWord.equals("A") || tempWord.equals("I")) {
                if (tempWord.length() == 1) {
                    return true;
                }
                if (analyze(tempWord, englishDictionary)) {
                    return true;
                }
            }
            tempStringBuffer.replace(0, word.length() - 1, word);
        }
        return false;
    }
}
