//package anagram;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//class LettersTest {
//
//  private List<String> lettersOfAnagram;
//  private List<String> lettersOfWords;
//  private List<String> lettersOfWordsNoMatches;
//  private List<String> wordList;
//  private List<String> anagram;
//  private Letters letters;
//
//  @BeforeEach
//  void init() {
//    lettersOfAnagram = new ArrayList<>();
//    lettersOfAnagram.add("a");
//    lettersOfAnagram.add("b");
//    lettersOfAnagram.add("a");
//
//    lettersOfWords = new LinkedList<>();
//    lettersOfWords.add("a");
//    lettersOfWords.add("b");
//
//    lettersOfWordsNoMatches = new LinkedList<>();
//    lettersOfWordsNoMatches.add("a");
//    lettersOfWordsNoMatches.add("a");
//    lettersOfWordsNoMatches.add("a");
//
//    wordList = new LinkedList<>();
//    wordList.add("ab");
//    wordList.add("de");
//
//    anagram = new LinkedList<>();
//    anagram.add("a");
//    anagram.add("b");
//    anagram.add("c");
//    anagram.add("d");
//    anagram.add("e");
//    anagram.add("f");
//
//    letters = new Letters(wordList);
//  }
//
//  @Test
//  public void shouldReturnDifferencesFromLetters() {
//    Assertions.assertEquals(Arrays.asList("a"), letters.deleteLettersIfPossible(lettersOfWords, lettersOfAnagram));
//  }
//
//  @Test
//  public void shouldReturnAllAnagramLetters() {
//
//    Assertions.assertEquals(lettersOfAnagram, letters.deleteLettersIfPossible(lettersOfWordsNoMatches, lettersOfAnagram));
//  }
//
//
//  @Test
//  public void ss() {
//    letters.deleteWordsFromLetters("abc", anagram);
//    letters.deleteWordsFromLetters("ef", anagram);
//    letters.deleteWordsFromLetters("ef", anagram);
//    Assertions.assertEquals(Arrays.asList("d"), anagram);
//  }
//
//
//  @Test
//  public void doIy() {
//    Letters letters = new Letters(Arrays.asList("abc", "def"));
//    letters.findAnagrams(anagram, new ArrayList(), 0);
//  }
//}