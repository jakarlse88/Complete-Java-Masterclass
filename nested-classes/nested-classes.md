# Nested classes

It's possible in Java to nest a class inside another class.

```java
class OuterClass {
    ...
    class NestedClass {
        ...
    }
}
```
Nested classes that are declared `static` are called *nested static classes*; non-static nested classes are called *inner classes*.

```java
class OuterClass {
    ...
    static class StaticNestedClass {
        ...
    }
    class InnerClass {
        ...
    }
}
```
A nested class is a member of its enclosing class. Non-static nested (inner) classes have access to others members of the enclosing class, even if they are declared private; static nested classes do not. Nested classes:
* Logically group classes used in one place only
* Increase encapsulation
* Lead to more readable and maintainable code

### Static nested class
A static nested class is associated with its outer class, as with class methods and variables. A static nested class cannot directly refer to instance variables or methods defined in its enclosing class; it can do so only through object reference. Static nested classes interact with the instance variables of its outer class and other classes like any top-level class, and is behaviorally a top-level class nested in another top-level class for packaging convenience. 

Static nested classes are accessed using the enclosing class name:
```java
OuterClass.StaticNestedClass
``` 

For example, to create an object for the static nested class:
```java
OuterClass.StaticNestedClass nestedObject =
     new OuterClass.StaticNestedClass();
 ``` 

### Inner (non-static nested) class
Associated with an instance of the enclosing class with direct access to that object's methods and fields (but beware shadowing). Because it is associated with an instance, it cannot itself define any static members. Objects that are instances of an inner class exist *within* an instance of the outer class. 

```java
class OuterClass {
    ...
    class InnerClass {
        ...
    }
}
```

An instance of `InnerClass` can exist only within an instance of `OuterClass` and has direct access to the methods and fields of its enclosing instance. Thus, to instantiate an inner class one must first instantiate the outer class, then create the inner object within the outer object:
```java
OuterClass.InnerClass innerObject = outerObject.new InnerClass();
```

There are two types of inner classes: local classes and anonymous classes.

#### Local class
An inner class defined inside of any scope block (such as a method), with scope restricted to that particular block. A local class has access to the members of its enclosing class, but only variables declared `final` or variables that are *effectively final* (ie. a variable whose value is never changed after initialization).  

When a local class accesses a local variable or paramter of the enclosing block it "captures" that variable or parameter (which is then called a *captured variable/paramter*). 

Similarly to inner classes, local classes cannot define or declare any static members. Local classes in static methods can only refer to static methods of the enclosing class. Local classes are non-static because they have access to instance members of the enclosing block. 

Interfaces are inherently static and cannot be declared inside blocks.

A local class can have static members provided that they are constant variables. 

#### Anonymous class
Anonymous classes enable one to declare and instantiate a class at the same time. They are like local classes except that they do not have a name. Use them if you need to use a local class only once. While local classes are class declarations, anonymous classes are expressions, which means that one define the class in another expression.

```java
        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";
            public void greet() {
                greetSomeone("tout le monde");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };
```
