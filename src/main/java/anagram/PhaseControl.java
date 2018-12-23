package anagram;

import java.util.List;

public class PhaseControl {

  private boolean letterDeleted;
  private boolean anagramLetterIsEmpty;
  private List<String> lettersToUse;

  public boolean isPossibleProcessDeeper() {
    return letterDeleted && !anagramLetterIsEmpty;
  }

  public void setLetterDeleted(boolean letterDeleted) {
    this.letterDeleted = letterDeleted;
  }

  public boolean isAnagramLetterIsEmpty() {
    return anagramLetterIsEmpty;
  }

  public void setAnagramLetterIsEmpty(boolean anagramLetterIsEmpty) {
    this.anagramLetterIsEmpty = anagramLetterIsEmpty;
  }

  public List<String> getAvailabeLetters() {
    return lettersToUse;
  }

  public void setLettersToUse(List<String> lettersToUse) {
    this.lettersToUse = lettersToUse;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("PhaseControl{");
    sb.append("letterDeleted=").append(letterDeleted);
    sb.append(", anagramLetterIsEmpty=").append(anagramLetterIsEmpty);
    sb.append('}');
    return sb.toString();
  }
}
