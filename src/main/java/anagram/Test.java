package anagram;

import java.util.ArrayList;
import java.util.List;

public class Test {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("a");
    list.add("a");
    list.add("b");
    list.add("b");
    list.add("c");
    list.add("c");
    System.out.println(list);

    List<String> letters = new ArrayList<>();
    letters.add("a");

    deleteLettersIfPossible(list, letters);
  }

  private static List<String> deleteLettersIfPossible(List<String> list, List<String> letters) {
    List<String> listToTest = new ArrayList<>(list);
    for (String letter : letters) {
      if (!listToTest.remove(letter)) {
        return list;
      }
    }
    return listToTest;
  }
}
