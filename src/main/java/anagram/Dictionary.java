package anagram;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.logging.log4j.util.Strings;

/**
 * The class return only the list of words which consists form letter of @param phrase <sentence>
 */
public class Dictionary {

  private static final String WORD_LIST_FILE_NAME = "wordlist";
  private final String phrase;

  public Dictionary(String phrase) {
    this.phrase = phrase;
  }

  private List<String> getWordsContainingSignificantLetters() {
    List<String> letters = getLettersFromSentence(phrase);
    List<String> list = new ArrayList<>();
    try (Stream<String> stream = Files.lines(getPathToDirecotry())) {
      list = stream
          .filter(line -> letters.containsAll(Arrays.asList(line.split(""))))
          .collect(Collectors.toList());
    } catch (IOException e) {
      e.printStackTrace();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    return list;
  }

  private Path getPathToDirecotry() throws URISyntaxException {
    return Paths.get((ClassLoader.getSystemResource(WORD_LIST_FILE_NAME).toURI()));
  }

  public List<String> getWordsContainingSignificantLetters_Filtered(String x, String y, String z, String w) {
    Objects.requireNonNull(x, "s");
    String xNormalized = normalizeNullAndEmptyValue(x);
    String yNormalized = normalizeNullAndEmptyValue(y);
    String zNormalized = normalizeNullAndEmptyValue(z);
    String wNormalized = normalizeNullAndEmptyValue(w);

    List<String> wordsContainingSignificantLetters = getWordsContainingSignificantLetters();
    return wordsContainingSignificantLetters.stream()
        .filter(getStringPredicate(xNormalized, yNormalized, zNormalized, wNormalized))
        .collect(Collectors.toList());

  }

  private String normalizeNullAndEmptyValue(String value) {
    return Strings.isBlank(value) ? " " : value;
  }

  private Predicate<String> getStringPredicate(String x, String y, String z, String w) {
    return word -> word.startsWith(x) || word.startsWith(y) || word.startsWith(z) || word.startsWith(w);//todo how to loop it by fix number parameters
  }


  private List<String> getLettersFromSentence(String phrase) {
    List<String> letters = new ArrayList<>(Arrays.asList(phrase.split(Strings.EMPTY)));
    letters.removeIf(c -> c.equals(" "));
    letters.sort(Comparator.reverseOrder());
    return new ArrayList<>(letters);
  }
}
