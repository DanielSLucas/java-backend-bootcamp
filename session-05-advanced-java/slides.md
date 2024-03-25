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