package anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnagramTest {
  //https://ponychallenge.trustpilot.com/api-docs/index.html#!/pony-challenge/post_pony_challenge_maze
//http://followthewhiterabbit.trustpilot.com/cs/step3.html
  private static final String HASH_CODE_1 = "e4820b45d2277f3844eac66c903e84be";
  private static final String HASH_CODE_2 = "23170acc097c24edb98fc5488ab033fe";
  private static final String HASH_CODE_3 = "665e5bcb0c20062fe8abaaf4628bb154";
  private String PHRASE = "printout stout yawls";
  private String PHRASE_2 = "ty outlaws printouts";
  private String PHRASE_3 = "wu lisp not statutory";


  public static List<String> getLetters(String phrase) {//todo
    List<String> letters = new ArrayList<>(Arrays.asList(phrase.split(Strings.EMPTY)));
    letters.removeIf(c -> c.equals(" "));
    letters.sort(Comparator.reverseOrder());
    return new ArrayList<>(letters);
  }

  @BeforeEach
  public void init() {

  }

  @Test
  public void shouldFind_Hash_CODE_1() {
    List<String> letters = getLetters(PHRASE);
    Dictionary dictionary = new Dictionary(letters);
    List<String> significantWordList = dictionary.getWordsContainingSignificantLetters();

    Letters lettersQ = new Letters(significantWordList, HASH_CODE_1);
    Assertions.assertEquals(PHRASE, lettersQ.findAnagramLoop(letters));
  }

  @Test
  public void shouldFind_Hash_CODE_2() {
    List<String> letters = getLetters(PHRASE);
    Dictionary dictionary = new Dictionary(letters);
    List<String> significantWordList = dictionary.getWordsContainingSignificantLetters();

    Letters lettersQ = new Letters(significantWordList, HASH_CODE_2);
    Assertions.assertEquals(PHRASE_2, lettersQ.findAnagramLoop(letters));
  }
  @Test
  public void shouldFind_Hash_CODE_3() {
    List<String> letters = getLetters(PHRASE);
    Dictionary dictionary = new Dictionary(letters);
    List<String> significantWordList = dictionary.getWordsContainingSignificantLetters();

    Letters lettersQ = new Letters(significantWordList, HASH_CODE_3);
    Assertions.assertEquals(PHRASE_3, lettersQ.findAnagramLoop(letters));
  }


  @Test
  public void shouldFindPhrase_ShortTest() {
    List<String> lettersTuUse = getLetters(PHRASE);
    List<String> significantWordList = Arrays.asList("yawls", "stout", "printout");
    Letters letters = new Letters(significantWordList, HASH_CODE_1);
    Assertions.assertEquals(PHRASE, letters.findAnagramLoop(lettersTuUse));
  }

}