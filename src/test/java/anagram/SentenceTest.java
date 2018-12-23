package anagram;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SentenceTest {

  private List<String> mixSentence4Elements;
  private List<String> mixSentence3Elements;

  @BeforeEach
  public void init() {
    Sentence sentence = new Sentence();
    mixSentence4Elements = sentence.prepareSentenceWitchPermutationWords("1", "2", "3", "4");
    mixSentence3Elements = sentence.prepareSentenceWitchPermutationWords("1", "2", "3");
  }

  @Test
  public void shouldHavCorrectSize_4Elements() {
    Assertions.assertEquals(24, mixSentence4Elements.size());
  }

  @Test
  public void shouldHavCorrectSize_3Elements() {
    Assertions.assertEquals(6, mixSentence3Elements.size());
  }

  @Test
  public void shouldContainElements_4Elements() {
    Assertions.assertTrue(mixSentence4Elements.contains("1 2 3 4"));
    Assertions.assertTrue(mixSentence4Elements.contains("1 2 4 3"));
    Assertions.assertTrue(mixSentence4Elements.contains("1 3 2 4"));
    Assertions.assertTrue(mixSentence4Elements.contains("1 3 4 2"));
    Assertions.assertTrue(mixSentence4Elements.contains("1 4 3 2"));
    Assertions.assertTrue(mixSentence4Elements.contains("1 4 2 3"));

    Assertions.assertTrue(mixSentence4Elements.contains("4 3 2 1"));
  }

  @Test
  public void shouldContainElements_3Elements() {
    Assertions.assertTrue(mixSentence3Elements.contains("1 2 3"));
    Assertions.assertTrue(mixSentence3Elements.contains("1 3 2"));
    Assertions.assertTrue(mixSentence3Elements.contains("1 3 2"));
    Assertions.assertTrue(mixSentence3Elements.contains("1 2 3"));

    Assertions.assertTrue(mixSentence3Elements.contains("3 2 1"));
  }
}