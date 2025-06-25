import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        long timeBeforeExecution;
        long timeAfterExecution;
        double timeToExecuteAnalysisInSeconds;
        ScrabbleDictionary scrabbleDictionary = new ScrabbleDictionary();
        List<String> nineLetterWordList = new ArrayList<>();
        Set<String> setNineLetterWords = scrabbleDictionary.scrabbleDictionaryList
                .stream()
                .filter(words -> words.length() == 9)
                .collect(Collectors.toSet());
        Set<String> setLessThanNineLetterWords = scrabbleDictionary.scrabbleDictionaryList
                .stream()
                .filter(words -> words.length() < 9)
                .collect(Collectors.toSet());

        timeBeforeExecution = System.currentTimeMillis();

        for (String word : setNineLetterWords) {
            if (AnalyzeWords.analyze(word, setLessThanNineLetterWords)) {
                nineLetterWordList.add(word);
            }
        }

        timeAfterExecution = System.currentTimeMillis();

        timeToExecuteAnalysisInSeconds =  (double) (timeAfterExecution - timeBeforeExecution) / 1000;

        System.out.printf("Time to perform analysis in seconds:%,.2f \n" +
                "Words found: %s%n", timeToExecuteAnalysisInSeconds, nineLetterWordList.size());
    }
}
