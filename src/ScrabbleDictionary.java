import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class ScrabbleDictionary {

    public ScrabbleDictionary() throws IOException {

    }

    final List<String> scrabbleDictionaryList = loadWords();

    public static List<String> loadWords() throws IOException {
        URL wordsUrl = new URL("https://raw.githubusercontent.com/nikiiv/JavaCodingTestOne/master/scrabble-words.txt");
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(wordsUrl.openConnection().getInputStream()))) {
            return br.lines().skip(2).collect(Collectors.toList());
        }
    }

}
