package anagram;

import com.google.common.collect.Collections2;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sentence {

  public static void main(String[] args) {
    Sentence sentence = new Sentence();
    List<String> strings = sentence.prepareMixWordsVariable("1", "2", "3");
    System.out.println(strings);


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

  public List<String> prepareSentenceWIthMixedWords(String word, String word1, String word2, String word3) {
    return Stream.of(
        getMixWords(word, word1, word2, word3),
        getMixWords(word1, word, word2, word3),
        getMixWords(word2, word1, word, word3),
        getMixWords(word3, word1, word, word3)
    )
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
  }

  public List<String> prepareMixWordsVariable(String... words) {
    List<String> out = new LinkedList<>();
    Collection<List<String>> permutations = Collections2.orderedPermutations(Arrays.asList(words));
    for (List<String> permutation : permutations) {
      out.add(prepareSentenceVariable(permutation));
    }
    return out;
  }

  private String prepareSentenceVariable(List<String> words) {
    return words.stream().collect(Collectors.joining(" ")).trim();
  }

}