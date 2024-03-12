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

# Collection interface hierarchy

Collection 
  -> Set -> SortedSet
  -> List
  -> Queue
  -> Deque

Map -> SortedMap

# List interface

- elements are stored in a specific order
- can be accessed by their index
- extends the `Collection` interface
- adds addtional methods for index based access

## Capabilities:

- positional access
- search
- iteration
- range view

## Implementations

- `ArrayList` (most used)
- `LinkedList`
- `Vector`
- `Stack`
- `CopyOnWriteArrayList`

## Use
```java
  // List<String> fruits = Arrays.asList("apple", "banana", "orange"); // mutable
  // List<String> fruits = List.of("apple", "banana", "orange"); // imutable
  List<String> fruits = new ArrayList<>();

  fruits.add("apple");
  fruits.add("banana");
  fruits.add("orange");

  System.out.println(fruits);
```

## ArrayList

Most operations are O(1) or O(n) ()in the worst cases, so in that case we say
that we have O(1) (amortized time complexity).

- O(1) if there is space
- O(n) if there is no space (so the array has to be copied to a new location in 
the heap, where it has more space, the double of size it had before)

## LinkedList

- doubly-liked list data structure
- each element in the list is connected to the next and previous elements
- not recommended for us in most situations
- most operations is O(n) on average
- some eperations, like append and remove at the end of the list, cabe done in O(1)

```java
  List<String> fruits = new LinkedList<>();

  fruits.add("apple");
  fruits.add("banana");
  fruits.add("orange");

  System.out.println(fruits.get(1));
  System.out.println(fruits);
```
