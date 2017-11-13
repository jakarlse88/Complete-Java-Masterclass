# Abstract classes

Abstraction, generally,  means defining a required functionality without actually implementing it; what needs to be done, 
but not how to do it. An *abstract class* is a class that is declared `abstract`, and may or may not include abstract methods. 
An *abstract method* is a method that is declared without an implementation (ie. without braces and followed by a semi-colon):
```java
abstract void moveTo(double deltaX, double deltaY);
```
If a class includes abstract methods it *must* itself be declared abstract:
```java
public abstract class graphicObject {
  // declare fields
  // declare non-abstract methods
  abstract void draw();
}
```
The subclass of an abstract class usually provides implementations for all the abstract methods in its parent class. If it does not, 
the subclass too must be declared `abstract`.

### Abstract classes vs. Interfaces
Abstract classes cannot be instantiated, and may contain a mix of abstract and implemented methods. Fields can be declared that are not 
`static` and `final`, and methods can be declared that are `public`, `protected`, and concrete. Only one class can be extended, whether 
abstract or not.

With an interface all fields are automatically `public`, `static`, and `final`, and all methods declared or defined (as default methods) 
are public (methods in an *interface* that are not declared as `default` or `static` are implicitly abstract, and so the `abstract` 
modifier is unnecessary although it *can* be used). Any number of interfaces can be implemented.

**Consider using abstract classes if:**
* Code will be shared among several closely related classes
* Classes that extend your abstract class have many common methods and fields, 
or require access modifiers other than `public` (such as protected and private)
* Non-`static` or non-`final` fields, enabling you to define methods that can access and modify the state of 
the object to which they belong, are required

**Consider using interfaces if:**
* Unrelated classes would implement the interface
* Multiple inheritance of type is necessary or desired
* One wants to specify the behaviour of a particular data type, but is unconcerned with who implements it

Note that it is possible to define a class that does not implement all of an interface's methods, provided that the class is declared to be `abstract`.

```java
abstract class X implements Y {
  // implements all but one method of Y
}

class XX extends X {
  // implements the remaining method in Y
}
```
Class X must be abstract because it does not fully implement Y, but class XX does, in fact, implement Y.
