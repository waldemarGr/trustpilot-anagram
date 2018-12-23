package anagram;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DictionaryTest {

  @Test
  void shouldReturnWordsStartAt_A_Letter() {
    Dictionary dictionary = new Dictionary("zabcde");
    List<String> a = dictionary.getWordsContainingSignificantLetters_Filtered("a", Strings.EMPTY, Strings.EMPTY, Strings.EMPTY);
    Assertions.assertTrue(a.stream().allMatch(wors -> wors.startsWith("a")));
  }

  @Test
  void shouldReturnWordsStartAt_A_And_B_Letter() {
    Dictionary dictionary = new Dictionary("zab cde");
    List<String> a = dictionary.getWordsContainingSignificantLetters_Filtered("a", "b", Strings.EMPTY, null);
    Assertions.assertTrue(a.stream().anyMatch(wors -> wors.startsWith("a")));
    Assertions.assertTrue(a.stream().anyMatch(wors -> wors.startsWith("b")));

    Assertions.assertTrue(a.stream().noneMatch(wors -> wors.startsWith("c")));
    Assertions.assertTrue(a.stream().noneMatch(wors -> wors.startsWith("z")));

    List<String> collect = a.stream().filter(word -> !word.startsWith("a") && !word.startsWith("b")).collect(Collectors.toList());
    Assertions.assertTrue(collect.isEmpty());
  }

}