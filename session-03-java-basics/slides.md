## The classic "Hello world" program

```java
public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello world");
    }

}
```
# My Notes:

## Primitive data types (values)

- int (whole numbers) 4 bytes -> 32 bits
- double (decimals) 8 bytes -> 64 bits
- float (shorter decimals) 4 bytes -> 32 bits
- long (longer whole numbers) 8 bytes -> 64 bits
- short (shorter whole numbers) 2 bytes -> 16 bits
- byte (even shorter whole number) 1 bytes -> 8 bits
- char (single character) 2 bytes -> 16 bits
- boolean (true or false)

## Non primitive data types (references)

- String (sequence of characters)
- Array (collection of similar data types that are indexable)
- Class (blueprint for creating objects) - data structures that has behaviours and attributes
- Interface (collection of abstract methods) - that must be implemented by the classes that implements that interface
- Enum (set of named values)
- Record (a "carrier" of data)

## Wrapper classes

All primitive types (e.g. intm float, boolean) have a corresponding wrapper class (e.g. Integer, Float, Boolean), to turn the primitive into an object to be used by other classes e add some methods to the type.

## Operators

Nothing really different from other programming languages.

## Arrays, Classes, Encapsulation, Inhritance, Polymorphism, Static keyword

Nothing really different from other programming languages.

## Inner classes (Non-static nested classes)

- **Member Inner class** - defined in another class, but outside a method

```java
// Definition
class Outer {
    private int x = 10;
    class Inner {
        void display() {
            System.out.println("Outer x: " + x);
        }
    }
}

// Use
Outer outer = new Outer();
Outer.Inner inner = outer.new Inner();
inner.display(); // prints "Outer x: 10"

// If it was a static inner class de use would be like this:
// Outer.Inner inner = new Outer.Inner()
```

- **Local Inner class** - defined inside a method

```java
class Outer {
    int x = 10;
    void doSomething() {
        // Definition
        class Inner {
            void display() {
                System.out.println("Outer x: " + x);
            }
        }
        // Use        
        Inner inner = new Inner();
        inner.display();
    }   
}
```

- **Anonymous Inner class** - defined inside a method, but without a name

```java
class Outer {
    int x = 10;
    void doSomething() {
        // Definition & Use
        new Inner() {
            void display() {
                System.out.println("Outer x: " + x);
            }
        }.display();
    }   
}
```

- **Lambda Expression** - functional inteface defined as a lambda expression

```java
class Outer {
    int x = 10;
    void doSomething() {
        // Definition
        MyFunction f = () -> System.out.println("Outer x: " + x);
        // Use
        f.call();
    }   
}
```