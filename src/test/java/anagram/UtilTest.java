package anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.apache.logging.log4j.util.Strings;

public class UtilTest {

  @SuppressWarnings("Duplicates")
  public static List<String> getLettersFromSentence(String phrase) {
    List<String> letters = new ArrayList<>(Arrays.asList(phrase.split(Strings.EMPTY)));
    letters.removeIf(c -> c.equals(" "));
    letters.sort(Comparator.reverseOrder());
    return new ArrayList<>(letters);
  }
}
