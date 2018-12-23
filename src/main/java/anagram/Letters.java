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

public class Letters {

  private final String hashCode;
  private final Sentence sentence = new Sentence();
  private final Logger LOG = LogManager.getLogger(Letters.class);
  private final List<String> words;

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

  private Model deleteWordsFromLetters(String word, List<String> lettersToUse) {
    List<String> lettersOfWord = Arrays.asList(word.split(""));
    boolean isLettersDeleted = deleteLettersIfPossible(lettersOfWord, lettersToUse);

    return new ModelBuilder()
        .withAnagramLetterIsEmpty(lettersToUse.isEmpty())
        .withLetterDeleted(isLettersDeleted)
        .withLeterToUse(lettersToUse)
        .build();
  }

  public String findAnagramLoopFromLetters(List<String> letters) {
    LOG.info("words: {} "
            + "\n number of words: {} "
            + "\nletters {} "
            + "\nnumbers of letter {}"
        , words, words.size(), letters, letters.size());

    DecodeMD5 decodeMD5 = new DecodeMD5(hashCode);
    Instant startTime = Instant.now();
    for (String word : words) {
      List<String> lettersToUse = new LinkedList<>(letters);
      Model model = deleteWordsFromLetters(word, lettersToUse);
      if (model.isPossibleProcessDeeper()) {
        for (String word1 : words) {
          List<String> winWords2 = new LinkedList<>(model.getLettersToUse());
          Model model1 = deleteWordsFromLetters(word1, winWords2);
          if (model1.isPossibleProcessDeeper()) {
            for (String word2 : words) {
              List<String> winWords3 = new LinkedList<>(model1.getLettersToUse());
              Model model2 = deleteWordsFromLetters(word2, winWords3);
              if (model2.isAnagramLetterIsEmpty()) {
                List<String> strings = sentence.prepareMixWordsVariable(word, word1, word2);

                LOG.info("Candidate to win:   {} ", word + " " + word1 + " " + word2);
                strings.forEach(sentence -> isWinner(decodeMD5, sentence, startTime));

                Optional<String> winnSentence = strings.stream()
                    .filter(sentence -> isWinner(decodeMD5, sentence, startTime))
                    .findFirst();

                if (winnSentence.isPresent()) {
                  return winnSentence.get();
                }

              } else if (model2.isPossibleProcessDeeper()) {
                for (String word3 : words) {
                  List<String> winWords4 = new LinkedList<>(model2.getLettersToUse());
                  Model model3 = deleteWordsFromLetters(word3, winWords4);
                  if (model3.isAnagramLetterIsEmpty()) {
                    List<String> strings = sentence.prepareSentenceWIthMixedWords(word, word1, word2, word3);

                    LOG.info("Candidate to win:   {} ", word + " " + word1 + " " + word2 + " " + word3);
                    strings.forEach(sentence -> isWinner(decodeMD5, sentence, startTime));

                    Optional<String> winnSentence = strings.stream()
                        .filter(sentence -> isWinner(decodeMD5, sentence, startTime))
                        .findFirst();

                    if (winnSentence.isPresent()) {
                      return winnSentence.get();
                    }
                  }
                }
              }
            }
          }
        }
      }
      System.out.println(String.format("%20s  %d/%d", word, words.size(), words.indexOf(word)));
    }
    Instant stop = Instant.now();
    long seconds = Duration.between(startTime, stop).getSeconds();
    System.out.println("Duration: " + seconds / 60 + " min" + seconds / 60 + " s");
    return null;
  }


  private boolean isWinner(DecodeMD5 decodeMD5, String sentence, Instant start) {
    if (decodeMD5.isMd5MachToSentence(sentence)) {
      LOG.info("The winner is   {}", sentence);
      Instant winner = Instant.now();
      long seconds = Duration.between(start, winner).getSeconds();
      System.out.println(seconds / 60 + " min" + seconds / 60 + " s");
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }

}

