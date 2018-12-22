package anagram;

import java.util.List;
import org.junit.jupiter.api.Test;

class SentenceTest {


  @Test
  public void should() {

    Sentence sentence = new Sentence();
    List<String> strings = sentence.prepareSentenceWIthMixedWords("1", "2", "3", "4");
    strings.forEach(sen -> System.out.println(sen+"\n"));
  }

}