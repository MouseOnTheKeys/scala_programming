### Week 4

#### Lecture 4.6 - Lists

The List is fundamental data structure in functional programming.

A list haveing x1,...,xn as elements written List(x1,...,xn)

```Scala
val fruit = List("apples","oranges","pears")
val nums = List(1,2,3,4,5)
val diag3 = List(List(1,0,0),List(0,1,0),List(0,0,1))
val empty = List()
```

There are two important differences between lists and arrays.

- Lists are immutable - the elements of the list cannot be changed.
- Lists are recursive, while arrays are flat.

**_List types_**

Like arrays, lists ate homogeneous: the elemants of the list must all have same type.
The type of the list with elements of type T is written scala.List[T] or shorter just List[T]

```Scala
val fruit: List[String] = List("apples", "oranges", "pears")
val nums : List[Int] = List (1,2,3,4,5)
val diag3: List[List[Int]] = List(List(1,0,0),List(0,1,0), List(0,0,1))
val empty: List[Nothing] = List()
```

All lists are constructed from:

- the empty list Nil, and
- the construction operation :: (pronounces cons):
  x :: xs gives a new list with the first element x, followed by the elementsof xs.

For exsample:

```Scala
fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
nums = 1:: (2 :: (3 :: (4 :: (5::))))
empty = Nil
```

**_Right Associativity_**

Convention: Operators ending in ":" associate to the right.

A :: B :: C is interpreted as A ::(B :: C).
we can thus omit the parentheses in the definition above.

Eample:
`val nums = 1 :: 2 :: 3 :: 4 :: Nil`

Operators ending in ":" are also different in the they are seen as method calls of the right-hand operand.
So the expression above is equivalent to

`Nil.::(4).::(3).::(2).::(1)'

**_Operations on Lists_**

All operations on lists can be expressed in terms of the following three operations:

```
head - the first elements of the list
tail - the list composed of all elements of the list except the first
isEmpty - 'true' if the list is empty, 'false' otherwise
```

These operations arte defined as methods of objects of type list. For example:

```
fruit.head      == "apples"
fruit.tail.head == "oranges"
diag3.head      == List(1,0,0)
empty.head      == throw new NoSuchElementException("head of an empty list")
```

**_List Patterns_**

```
Nil                 The Nil constant
p :: ps             A pattern that matches a list with head matching p and a tail matching ps.
List(p1,...,pn)     Same as p1 :: ... :: pn :: Nil
```

Example:

```
1 :: 2 :: xs        List that start with 1 and then 2
x :: Nil            List of length 1
List(x)             Same as x :: Nil
List()              The empty list, same as Nil
List(2 :: xs)       A list that contains as only element anothor list that start with 2
```

**_Sorting List_**
Suppose we want to sort a list of numbers in ascending order:

- One way is to sort the list List(7,3,9,2) is to sort the tail List(3,9,2) to obtain List(2,3,9)
- The nest step is to insert the head 7 in the right place to obtain the result List(2,3,7,9)

The idea describes Insertion Sort:

```Scala
def isort(xs: List[Int]): List[Int] = xs match {
    case List() == List()
    case y :: ys => insert(y, isort(ys))
}
```
