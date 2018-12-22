package anagram;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sentence {


  public List<String> prepareSentenceWIthMixedWords(String word, String word1, String word2, String word3) {
    return Stream.of(
        getMixWords(word, word1, word2, word3),
        getMixWords(word1, word, word2, word3),
        getMixWords(word2, word1, word, word3),
        getMixWords(word3, word1, word, word3)
    )
        .flatMap(x -> x.stream())
        .collect(Collectors.toList());
  }

  private List<String> getMixWords(String word, String word1, String word2, String word3) {
    return Arrays.asList(
        prepareSentence(word, word1, word2, word3),
        prepareSentence(word, word1, word3, word2),

        prepareSentence(word, word2, word1, word3),
        prepareSentence(word, word2, word3, word1),

        prepareSentence(word, word3, word1, word2),
        prepareSentence(word, word3, word2, word1));
  }

  private String prepareSentence(String word, String word1, String word2, String word3) {
    return word + " " + word1 + " " + word2 + " " + word3;
  }




}