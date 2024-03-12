# Time complexity

How much time it takes to solve a problem.

- O(1) -> constant time complexity (e.g. getting the first element of a given array)
- O(n) -> Linear time (e.g. search through all elements of a given array)
- O(n^2) -> Quadractic time complexity (e.g. search through all elements of a given two dimensional array)
- O(log n) -> Logarithmic time complexity (e.g. binary search)

# Space complexity

How much space it takes to solve a problem.

- Dynamic proggraming -> save the results for some set of arguments, to avoid
doing the processing again (e.g. caching or memoization). This processe decreases
the time complexity but increases the space complexity, and this is an acceptable
trade-off since space is easier to expand the space than the computing power.

# Comparator and Comparable

*Comparator* it's an interface that objects that can be compared can implement.

Objects that implements this interface should implement the method `compareTo`, which
should return a positive integer if it's greater, zero if it's equal and a negative 
integer if lesser than the other object.

```java
public class Person implements Comparable<Person> {
  private String name;
  private int age;

  // getters and setters...

  @Override
  public int compareTo(Person other) {
    return Integer.compare(this.age, other.age);
  }
}
```

*Comparable* it's also an interface that classes implements to compare a type of
objects by other member variables than the one used in the `compareTo` method.

Objects that implements this interface should implement the `compare` method, and
it must return an integer.

```java
public class PersonComparator implements Comparator<Person> {
  @Override
  public int compare(Person person1, Person person2) {
    return person1.getName().compareTo(person2.getName());
  }
}
```

Example:
```java
List<Person> people = new ArrayList<>();
people.add(new Person("Foo", 45));
people.add(new Person("Bar", 31));
people.add(new Person("Baz", 22));

// Sort using the comparable interface
Collections.sort(people);

// Sort using the comparator interface
PersonComparator nameComparator = new PersonComparator();
Collections.sort(people, nameComparator);
```

# Iterator pattern

A way to traverse a collection of objects without exposing its underlying 
representation.

-> Look at `IteratorExercise.java`.

# Fail-fast iterators

Fail-fast iterators throw ConcurrentModificationException on a **best-effort** basis.

- Iterators not tolerant to underlying changes
- users an internal modification counter
- throws ConcurrentModificationException if modified since last `next`

*You can use the iterator to modify itself more securely. (like iterator.remove())
