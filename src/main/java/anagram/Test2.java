package anagram;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test2 {

  public static void main(String[] args) {

    List<Integer> collect = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
    Test2 test = new Test2();
    List<Integer> result = new LinkedList<>();

    test.go2(collect, result, 0);
  }

  private static void met(List<Integer> collect) {
    List<Integer> list;
    for (Integer integer : collect) {
      list = new LinkedList();
      list.add(integer);

      for (Integer integer1 : collect) {
        list.add(integer1);
      }
      System.out.println(list);
    }
  }

  public void go2(List<Integer> numbers, List<Integer> result, Integer deep) {
    deep++;
    List<Integer> resultTmp= Collections.emptyList();
    for (Integer integer : numbers) {
    resultTmp = new LinkedList<>(result);
      resultTmp.add(integer);
    System.out.println(resultTmp);
      if (deep <= 3) {
        go2(numbers, resultTmp, deep);
      }
    }
  }
}
