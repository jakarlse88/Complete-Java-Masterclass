# Nested classes

It's possible to nest a class inside another class.

### Static nested class
Mainly useful in order to associate a class with its outer class. Behaviourally identical to a top level class, but packaged in its outer class (rather than in the overall package). Cannot access outer class's non-static members nor methods without creating an instance of that class.

### Non-static nested class (inner class)
Useful when it doesn't make sense to refer to a class without its outer class (ie. on its own). Can access any field or method of its outer class, but beware of variable shadowing. An inner class is a member of and must be created within an instance of its outer class. These classes are often private, and can improve encapsulation. 

### Local class
An inner class defined inside of a scope block such as a method, with scope restricted to that particular block. Used less often.

### Anonymous class
A nested class without a class name. Must be declared and instantiated at the same time. Used when a local class is required only once. Also common for touching event handlers to use in an interface.
