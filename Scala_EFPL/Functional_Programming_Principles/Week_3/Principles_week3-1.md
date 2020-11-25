### Week 3

#### Lecture 3.1

**Class Hierarchies**

*Abstract classes*
Cosider the tsk of writing a class for sets of integers with the following operations.

```Scala
abstract class IntSer{
    def incl(x: Int): IntSet

    def contains(x: Int): Boolean
}
```
IntSet is an  *abstract class*.

Abstract classes can contain members which are missing an implementation (in our case, incl and constants).

Consequtevely, no instances of an abstraction class can be created with the operator new.

**Class Extension**

Let's  consider implementing sets as binary trees.
There are two types of possible trees: a tree for the empty set, and a tree consisting of an integer and two sub-trees.

Here are the implementations:
```Scala
class Empty extends IntSet {
    def contains(x: Int): Boolean = false
    def incl(x: Int): IntSet = new NonEmpty(x,new Empty, new Empty)
}
```
`contain` is always false because the empty tree can not contain any value.

Now we neeed to define what the non empty set would be:
```Scala
class Non Empty(elem: Int, left: IntSet, right IntSet) extends IntSet {
    def contains(x: Int): Boolean =
        if (x < elem) left contains x
        else if(x > elem) right contains x
        else true

    def incl(x:Int): IntSet =
        if (x < elem) new NonEmpty(elem, left incl x, right)
        else if (x > elem) new NonEmpty(elem, left, right incl x)
        else this
}
```
No mutations involved. Adding elemnet on tree means included elements  + creating new element on tree.

**Terminology**

Empty and NonEmpty both extends the class InSet.

This implies that the types Empty and NonEmpty conform to the type IntSet
- an object of type Empty and NonEmpty can be used wherever an object of type IntSet is required.

IntSet is called the *superclass* of Empty and NonEmpty.
Empty and NonEmpty are *subclasses of IntSet.

In Scala, any user-defined class extends another class.

If no superclass is given, the standard class Object in the JAva package `java.lang` is assumed.

The direct or indirect superclasses of a class C are called *base classes* of C.

So, the base classes of NonEmpty are IntSet and Object.

The definitions of contains and incl in the classes Empty and NonEmpty *implement* the abstract functions in the base trait IntSet.

It is also possible  to redefine an existing non-abstract definition in a subclass by using override.

Example:
```Scala
abstract class Base [
    def foo = 1
    def bar : Int
]

class Sub extends Base {
    override def foo = 2
    def bar = 3
}
```
In the IntSet example one could argue that there is really only one a singe empty IntSet.

So it seems  overkill to have the user create many Instances of it.

We can express this case better with an *object* deffinition

```Scala
object Empty extends IntSet {
    def contains(x: Int): Boolean = false
    def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
}
```
This defines a **singleton object** named Empty.
No other Empty instances can be (or need to be) created,
Singleton objects are values, so Empty evaluets to itself.

**Programs**
What a program would be in Scala ?
So far we executed all Scala code from REPL or the worksheet.
But it is also possible to create a standalone appliccation in Scala.
Each such application contain an object with main method.
For instance, here is the "Hello World !" program in Scala.
```Scala
object Hello {
    def main(args: Array[String])= println("Hello World !")
}
```

Once the program is compiled, you can stat it from the command line with:
`> scala Hello.scala`.

Object-Oriented languages (inluding Scala) implement dynamic method dispatch.

This means that the code invoked by a method call depends on the runtime type of the object that contains the method.

Dynamic dispatch of methods is analogous to calls to higher-order functions.

Can we implement one concept i terms of other?
- Objects in terms of high-order functions ?
- Higher-order functions in terms of objects ?

he similarity is that in both cases the code that gets executed
on a functional method call is not known statically.
It's not apparent from the name or the type of the thing you called.
But it is determined by the run time value that is passed.