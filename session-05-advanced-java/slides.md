# Functional programming

-> Functional programming is: composing code using pure functions.

-> Functions contains imperative code withing itself, to help us write a more
declarative code.

-> Pure functions are functions that only manages the parameters and no external
variables/data.

-> Methods are different from functions because:
  - they belong to a class
  - they can/might access class member variables 

## Lambda expression

Lambda expression is the way java can do functional programming, pass down behaviours
instead object instances.

- Lambda functions syntax:
```java
  // one line lambda
  x -> x + 1; // receives and returns a int. But doesnt do nothing by itself, has to be assigned and called
  
  // receives two parameters and can have a multiline body
  (int x, int y) -> {
    return x + y;
  };

  // no parameters, no return
  () -> System.out.println("Hello world!");
```

- Lambda expressions are typed using interfaces with a Single Abstract Method (SAM).

Here is an example of a lambda expression assigned to a variable `addFunc` and being called:

```java
  public void main() {
    MyFunction addOneFunc = x -> x + 1;

    System.out.println(addOneFunc.run(1)); // outputs 2
  }

  @FunctionalInterface // annotation to enforce that is a functional interface
  interface MyFunction {
    int run(int x);
  }
```

More Examples: LambdaExamples.java, TaskRunner.java, Calculator.java

## Lambda vs anonymous classes

You could do the same as the last example using anonymous classes:

```java
  public void main() {
    System.out.println(
      new MyFunction() {
        @Override
        public int run(int x) {
          return x + 1;
        }
      }.run(1)
    ); // outputs 2
  }

  interface MyFunction {
    int run(int x);
  }
```

If so, why should I use lambda expressions?
- less verbose
- more efficient (anonymous classes trigger object creation, while lambdas
doesnt generate the class until the first invocation (lazy, invokedynamic called))

## JDK functional interfaces

- prebuilt interfaces for common lambda signatures
- helps avoid having to create functional interfaces
- in `java.util.functional` package
- doesnt cover everything
- Divided in four categories:
    - Functions

      One arg, one return -> Interface `Function<T, R>`
      
      A lambda function that receives an argument of type `T`
      and returns a value of type `R`.
      
      ```java
      // Receives a int and returns a int
      Function<Integer, Integer> myFunc = x -> x * 2;
      myFunc.apply(10);
      // Receives a int and returns a string
      Function<Integer, String> foo = x -> "value is " + x;
      ```
    - Consumers

      one arg, no return -> Interface `Consumer<T>`
      
      ```java
      Consumer<String> greeting = name -> System.out.println("Hello, " + name);
      greeting.accept("Koushik");
      ```
    - Suppliers

      no args, returns something -> Interface `Supplier<T>`

      ```java
      Supplier<Double> random =  () -> Math.random();
      random.get();
      ```
    - Predicates

      one arg, returns a Boolean -> Interface `Predicate<T>`

      ```java
      Predicate<Integer> isEven = num -> (num % 2) == 0;
      isEven.test(5);
      ```
    - Runnable

      `Runnable` interface for lambdas that has no input args and no return.
      
      ```java
      Runnable hello = () -> System.out.println("Hello world!");
        hello.run();
      ```
  - If you two args instead of one, you could use one of these interfaces: 
  `BiFunction<T, U, R>`, `BiConsumer<T, U>`, `BiPredicate<T, U>`.
  - If the lambda has the same return type as the input argument you can use the
  `Operator` like:
  ```java
  UnaryOperator<Integer> myFunc = x -> x * 2;
  BinaryOperator<String> concat = (a, b) -> a.concat(b);
  ```

## Method reference

Method reference is a syntax shortcut, that you can use address a method 
behavior to a lambda.

So this:
```java
Supplier<Double> random = () -> Math.random();
```
Can be written like this:
```java
Supplier<Double> random = Math::random;
```

Another examples of equivalent code:
```java

Consumer<String> printName = name -> System.out.println(name);
Consumer<String> printName = System.out::println(name);

UnaryOperator<String> trim = str -> str.trim();
UnaryOperator<String> trim = String::trim;

BiPredicate<String, String> isCaseInsensitiveEqual = (a, b) -> a.equalsIgnoreCase(b);
BiPredicate<String, String> isCaseInsensitiveEqual = String::equalsIgnoreCase;
```

*More examples at: `MethodReferencesDemo.java`

## Lambdas calling lambdas

Look at: `LambdaComposability.java`

## Composability with `andThen` and `compose`

Look at: `ComposableFunctions.java`

## Closures

- lambdas can access variables in scope
- but run in a completely different scope
- what happens to the variables?
- Java remembers and "locks" the values
- the value is used when the lambda runs

Example at: `ScopesProblem.java`