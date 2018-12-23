package anagram;

import java.util.LinkedList;
import java.util.List;

public class ModelBuilder {

  private boolean letterDeleted;
  private boolean anagramLetterIsEmpty;
  private List<String> lettersToUse;


  public ModelBuilder withLetterDeleted(boolean letterDeleted) {
    this.letterDeleted = letterDeleted;
    return this;
  }

  public ModelBuilder withAnagramLetterIsEmpty(boolean anagramLetterIsEmpty) {
    this.anagramLetterIsEmpty = anagramLetterIsEmpty;
    return this;
  }

  public ModelBuilder withLetterToUse(List<String> lettersToUse) {
    this.lettersToUse = new LinkedList<>(lettersToUse);
    return this;
  }


  public Model build() {
    Model model = new Model();
    model.setLetterDeleted(letterDeleted);
    model.setAnagramLetterIsEmpty(anagramLetterIsEmpty);
    model.setLettersToUse(lettersToUse);
    return model;
  }
}
