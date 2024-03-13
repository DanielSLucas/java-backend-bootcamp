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
- consumes more memory than an `ArrayList` or a `Vector`

```java
  List<String> fruits = new LinkedList<>();

  fruits.add("apple");
  fruits.add("banana");
  fruits.add("orange");

  System.out.println(fruits.get(1));
  System.out.println(fruits);
```

## Vector

- similar to ArrayList
- but it is synchronized (so **thread-safe**)
- uncommon usage

## Autoboxing with Lists

List interface can be used with autoboxing to store primitive data types.

```java
  List<Integer> number = new ArrayList<>();

  number.add(1);
  number.add(2);
  number.add(3);

  System.out.println(number);
```

## CopyOnWriteArrayList

- thread-safe variant of `ArrayList`
- concurrent collection class
- uses a copy-on-write strategy
- ensures that multiple threads can read the list simultaneously without the need
for locks.
- well-suited when many threads will be reading the list, but relatively few 
will be modifying it
- less efficient than a standard `ArrayList` when modifications are frequent

## Iterators for List

The default iterator uses index ordering and has the methods `hasNext`, `next` and `remove`.
But there is also an list specifica iterator called `ListIterator`.

## ListIterator

- list specific
- Allows you tu iterate both foward and backward directions
- `hasPrevious` and `previous` operations

```java
  List<String> number = new ArrayList<>();

  number.add('Item 1');
  number.add('Item 2');
  number.add('Item 3');
  number.add('Item 4');

  ListIterator<String> iterator = list.listIterator();

  // Foward traversal
  while (iterator.hasNext()) {
    System.out.println(iterator.next());
  }

  // Backward traversal
  while (iterator.hasPrevious()) {
    System.out.println(iterator.previous());
  }
```

### Additional Methods

- set

```java
  public static <E> void replace(List<E> list, E val, E newVal) {
    for (ListIterator<E> it = list.listIterator(); it.hasNext(); ) {
      if (val.equals(it.next())) {
        it.set(newVal);
      }
    }
  }
```

- add

```java
  public static <E> void replace(List<E> list, E val, List<? extends E> newVal) {
    for (ListIterator<E> it = list.listIterator(); it.hasNext(); ) {
      if (val == null ? it.next() == null : val.equals(it.next())) {
        it.remove();
        for (E e : newVals) {
          it.add(e)
        }
      }
    }
  }
```

## SubList

- List method that returns a "slice" of the orinal list. 
- The returned list is backed by the original list (changes in the original 
will reflect in the new one)
- Usefull whenever you need to perform an operation on a range

```java
  List<String> fruits = new ArrayList<>();

  fruits.add("apple");
  fruits.add("banana");
  fruits.add("orange");
  fruits.add("pear");
  fruits.add("mango");
  fruits.add("kiwi");

  List<String> subList = fruits.subList(1, 4);
  System.out.println(subList); // [banana, orange, pear]

  fruits.set(1, "bananaaaaa");
  System.out.println(subList); // [bananaaaaa, orange, pear]
```

How to clear (remove) a range:

```java
  list.subList(fromIndex, toIndex).clear();
```

## Equals with lists

Two lists are defined to be equal if they contain the same elements in the same order.

The `equals` method returns true if and only if the specified object is also a list, 
both lists have the same size, and all corresponding pairs of elements in the two lists are equal.

## Set Interface

It's a Collection tha cannot contain duplicate elements

- mathematical set abstraction
- no duplicates allowed
- automatically dedupes
- Only methods from collection
- Strong contract for equals
- can only contain one `null`

### Use
```java
  Set <person> people = new HashSet<Person>();
  // or you could
  Collection<Person> people = new HashSet<Person>();
```

### Remove duplicates
```java
  Collection<Type> noDups = new HashSet<Type>(c);
```

### Set Implementations

- HashSet
- TreeSet
- LinkedHashSet

## HashSet

- **stores elements in a hash table**
- best performing Set
- no guarantee of order
- fail-fast
- not syncronized
- operations are usually O(1) depending on the hash function of the element.

## Load Factor

load Factor = num of elem / num of buckets 
-> Buckets are the "place" where the elements of a set are stored. 
-> Buckets stores elements that have a hashcode in his range of hashcodes. 
-> As the number of the elements increases the load factor decreases, that is the
way which the set knows if it has to double the number of buckets.


## LinkedHashSet

- **implemented as a hash table with a linked list running through it**
- Quite similar to HashSet but it provides insertion ordering

## SortedSet and TreeSet

- total ordering of elements
- natural ordering
- `Comparator` can be supplied
- Iterator defaults to ascending order
- Additional operations
- The `SortedSet` is a interface which the `TreeSet` implements.
- Each element **must be comparable**
- performance: `add` = O(log n) and `contains` = O(log n)
- balance the tree in O(log n) time

Example at: SortedSetExample.java