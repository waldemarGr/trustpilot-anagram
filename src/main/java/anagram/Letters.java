package anagram;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Strings;

public class Letters {

  private final String hashCode;
  private final Sentence sentence = new Sentence();
  private final Logger LOGGER = LogManager.getLogger(Letters.class);
  private final List<String> words;
  private DecodeMD5 decodeMD5;

  public Letters(List<String> words, String hashCode) {
    this.words = words;
    this.hashCode = hashCode;
  }


  private boolean deleteLettersIfPossible(List<String> lettersOfWord, List<String> allLettersAnagram) {
    List<String> copyAllLettersAnagram = new ArrayList<>(allLettersAnagram);
    for (String letter : lettersOfWord) {
      if (!copyAllLettersAnagram.remove(letter)) {
        return false;
      }
    }
    allLettersAnagram.clear();
    allLettersAnagram.addAll(copyAllLettersAnagram);
    return true;
  }

  private PhaseControl deleteWordsFromLetters(String word, List<String> lettersToUse) {
    List<String> lettersOfWord = Arrays.asList(word.split(""));
    boolean isLettersDeleted = deleteLettersIfPossible(lettersOfWord, lettersToUse);

    return new ModelBuilder()
        .withAnagramLetterIsEmpty(lettersToUse.isEmpty())
        .withLetterDeleted(isLettersDeleted)
        .withLetterToUse(lettersToUse)
        .build();
  }

  public String findAnagramFromLetters(List<String> letters) {
    Instant startTime = Instant.now();
    LOGGER.info("words: {} "
            + "\n number of words: {} "
            + "\nletters {} "
            + "\nnumbers of letter {}"
        , words, words.size(), letters, letters.size());
    String anagramLoopFromLetters = findAnagramLoopFromLetters(letters);
    Instant stop = Instant.now();
    long seconds = Duration.between(startTime, stop).getSeconds();
    LOGGER.info("Duration: {}min {}s ", seconds / 60, seconds % 60);

    return anagramLoopFromLetters;
  }

  private String findAnagramLoopFromLetters(List<String> letters) {

    decodeMD5 = new DecodeMD5(hashCode);

    for (String word_1st : words) {
      List<String> lettersToUse = new LinkedList<>(letters);
      PhaseControl phaseControlLevel1st = deleteWordsFromLetters(word_1st, lettersToUse);
      if (phaseControlLevel1st.isPossibleProcessDeeper()) {
        for (String word_2nd : words) {
          List<String> lettersToUse2 = new LinkedList<>(phaseControlLevel1st.getAvailabeLetters());
          PhaseControl phaseControlLevel2nd = deleteWordsFromLetters(word_2nd, lettersToUse2);
          if (phaseControlLevel2nd.isPossibleProcessDeeper()) {
            for (String word_3rd : words) {
              List<String> lettersToUse3 = new LinkedList<>(phaseControlLevel2nd.getAvailabeLetters());
              PhaseControl phaseControlLevel3rd = deleteWordsFromLetters(word_3rd, lettersToUse3);
              if (phaseControlLevel3rd.isAnagramLetterIsEmpty()) {
                Optional<String> winSentenceWith3Words = getWinSentence(word_1st, word_2nd, word_3rd, Strings.EMPTY);
                if (winSentenceWith3Words.isPresent()) {
                  return winSentenceWith3Words.get();
                }
              } else if (phaseControlLevel3rd.isPossibleProcessDeeper()) {
                for (String word_4th : words) {
                  Optional<String> winSentenceWith4Words = find4thWord(word_1st, word_2nd, word_3rd, word_4th, phaseControlLevel3rd.getAvailabeLetters());
                  if (winSentenceWith4Words.isPresent()) {
                    return winSentenceWith4Words.get();
                  }
                }
              }
            }
          }
        }
      }
      LOGGER.debug(String.format("%20s  %d/%d", word_1st, words.size(), words.indexOf(word_1st)));
    }

    return null;
  }

  private Optional<String> find4thWord(String word, String word1, String word2, String word3, List<String> lettersToUse) {
    Optional<String> winSentence = Optional.empty();
    List<String> winWords4 = new LinkedList<>(lettersToUse);
    PhaseControl phaseControl3 = deleteWordsFromLetters(word3, winWords4);
    if (phaseControl3.isAnagramLetterIsEmpty()) {
      winSentence = getWinSentence(word, word1, word2, word3);

    }
    return winSentence;
  }

  private Optional<String> getWinSentence(String word, String word1, String word2, String word3) {
    List<String> strings = sentence.prepareSentenceWitchPermutationWords(word, word1, word2, word3);

    LOGGER.info("Candidate to win:   {} ", word + " " + word1 + " " + word2);
    strings.forEach(this::isWinner);

    return strings.stream()
        .filter(this::isWinner)
        .findFirst();
  }


  private boolean isWinner(String sentence) {
    if (decodeMD5.isMd5MachToSentence(sentence)) {
      LOGGER.info("The winner is   {}", sentence);
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }

}

