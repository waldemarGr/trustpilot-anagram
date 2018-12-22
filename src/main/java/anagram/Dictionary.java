package anagram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dictionary {

  private final static String WORD_LIST_PATH = "c://wordlist";
  private final List<String> letters;

  public Dictionary(List<String> letters) {
    this.letters = letters;
  }

    public List<String> getWordsContainingSignificantLetters() {
    List<String> list = new ArrayList<>();
    try (Stream<String> stream = Files.lines(Paths.get(WORD_LIST_PATH))) {
      list = stream
          .filter(line -> letters.containsAll(Arrays.asList(line.split(""))))
          .collect(Collectors.toList());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return list;
  }
}
