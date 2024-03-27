package io.javabrains.functionaljava;

import java.util.function.Function;

public class ScopesProblem {
  
  public static Function<Integer, Integer> counter() {
    int count = 0;

    return x -> count + 1;
  }

  public static void main(String[] args) {
    Function<Integer, Integer> counterFunction = counter();

    System.out.println(counterFunction.apply(0));
    System.out.println(counterFunction.apply(0));
  }
}
