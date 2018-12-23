package anagram;

import java.util.List;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LettersTest {

  //https://ponychallenge.trustpilot.com/api-docs/index.html#!/pony-challenge/post_pony_challenge_maze
//http://followthewhiterabbit.trustpilot.com/cs/step3.html
  private static final String HASH_CODE_1 = "e4820b45d2277f3844eac66c903e84be";
  private static final String HASH_CODE_2 = "23170acc097c24edb98fc5488ab033fe";
  private static final String HASH_CODE_3 = "665e5bcb0c20062fe8abaaf4628bb154";
  private String PHRASE = "printout stout yawls";
  private String PHRASE_2 = "ty outlaws printouts";
  private String PHRASE_3 = "wu lisp not statutory";

  private static final String ANAGRAM_java_is_fun = "ajfn iau vs";
  private static final String PHRASE_java_is_fun = "java is fun";
  private static final String HASH_CODE_java_is_fun = "92c74ca18c237c0b384cd72b7dc4f9dd";

  private static final String PHRASE_java_eight_is_fun = "java eight is fun";
  private static final String ANAGRAM_java_eight_is_fun = "java eight is fun";
  private static final String HASH_CODE_java_eight_is_fun = "4624c5cf6d10f8573d908f3457081b30";

  @BeforeEach
  public void init() {

  }

//  @Test
//  public void shouldFind_HashCode_1_FullTest() {
//    Dictionary dictionary = new Dictionary(PHRASE);
//    List<String> significantWordList = dictionary.getWordsContainingSignificantLetters();
//
//    Letters lettersQ = new Letters(significantWordList, HASH_CODE_1);
//    List<String> lettersFromSentence = UtilTest.getLettersFromSentence(PHRASE);
//    Assertions.assertEquals(PHRASE, lettersQ.findAnagramLoopFromLetters(lettersFromSentence));
//  }
//
//  @Test
//  public void shouldFind_HashCode_2_FullTest() {
//    Dictionary dictionary = new Dictionary(PHRASE_2);
//    List<String> significantWordList = dictionary.getWordsContainingSignificantLetters();
//
//    Letters lettersQ = new Letters(significantWordList, HASH_CODE_2);
//    List<String> lettersFromSentence = UtilTest.getLettersFromSentence(PHRASE_3);
//    Assertions.assertEquals(PHRASE_2, lettersQ.findAnagramLoopFromLetters(lettersFromSentence));
//  }
//
//  @Test
//  public void shouldFind_HashCode_3_FullTest() {
//    Dictionary dictionary = new Dictionary(PHRASE_3);
//    List<String> significantWordList = dictionary.getWordsContainingSignificantLetters();
//
//    Letters lettersQ = new Letters(significantWordList, HASH_CODE_3);
//    List<String> lettersFromSentence = UtilTest.getLettersFromSentence(PHRASE_3);
//    Assertions.assertEquals(PHRASE_3, lettersQ.findAnagramLoopFromLetters(lettersFromSentence));
//  }



  @Test
  public void shouldFindPhrase3Elements_ShortTest() {
    Dictionary dictionary = new Dictionary(ANAGRAM_java_is_fun);
    List<String> lettersFromSentence = UtilTest.getLettersFromSentence(ANAGRAM_java_is_fun);
    List<String> significantWordList = dictionary.getWordsContainingSignificantLetters_Filtered("j", "i", "f", Strings.EMPTY);
    Letters letters = new Letters(significantWordList, HASH_CODE_java_is_fun);
    Assertions.assertEquals(PHRASE_java_is_fun, letters.findAnagramFromLetters(lettersFromSentence));
  }

  @Test
  public void shouldFindPhrase4Elements_ShortTest() {
    Dictionary dictionary = new Dictionary(ANAGRAM_java_eight_is_fun);
    List<String> lettersFromSentence = UtilTest.getLettersFromSentence(ANAGRAM_java_eight_is_fun);
    List<String> significantWordList = dictionary.getWordsContainingSignificantLetters_Filtered("j", "i", "f", "e");
    Letters letters = new Letters(significantWordList, HASH_CODE_java_eight_is_fun);
    Assertions.assertEquals(PHRASE_java_eight_is_fun, letters.findAnagramFromLetters(lettersFromSentence));
  }

}