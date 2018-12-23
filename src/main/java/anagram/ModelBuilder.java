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


  public PhaseControl build() {
    PhaseControl phaseControl = new PhaseControl();
    phaseControl.setLetterDeleted(letterDeleted);
    phaseControl.setAnagramLetterIsEmpty(anagramLetterIsEmpty);
    phaseControl.setLettersToUse(lettersToUse);
    return phaseControl;
  }
}
