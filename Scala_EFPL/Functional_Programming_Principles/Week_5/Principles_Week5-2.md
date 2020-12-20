### Week 5

#### Lecture 5.2 - Pairs and Tuples

As non-trivial example let's design the function that is more efficient than insertion sort.

A good example is this _Merge sort_. The idea is as follows:

If the list consist of zero and one elements, it is already sorted.

Otherwise,

- Separate the list into two sub-lists, each containingarounf the ha;f of the elements of the origi nal list
- Sort the two sub-lists
- Merge the two sorted sub-;ists into single sorted list.

```Scala
def msort(xs: List[Int]): List[Int] = {
    val n = xs.length/2
    if (n == 0) xs
    else {
        def merge(xs: List[Int], ys: List[Int]) = ??
        val (fst, snd) = xs splitAt n
        merge(msort(fst), msort(snd))
    }
}
```

**_Merge Function_**

```Scala
def merge(xs: List[Int], ys: List[Int]) =
    xs match {
        case Nil =>
            ys
        case x :: xs1 =>
            ys match {
                case Nil =>
                    xs
                case y :: ys1 =>
                    if (x < y) x :: merge(xs1, ys)
                    else y :: merge(xs, ys1)
            }
        }
```

**_Pairs and Tuples_**

The pair consists of x and y is written (x, y) in Scala
**_Example_**

```
val pair = ("answer" , 42)  >   pair: (String, Int) = (answer,42)
```

The type of pair above is (String, Int).
Pair can also be used as patterns:

```Scala
val (label, value) = pair   >   label: String = answer
                            |   value: Int = 42
```

This works analogiously for tuples with more then two elements.

**_The Tuple Class_**

Here all Tuple n classes are modeld after the following pattern:

```
case class Tuple2[T1, T2](_1: +T1, _2: +T2) {
    override def toString = "(" + _1 + "," + _2 + ")"
}
```

The fields of a tple can be accessed with names \_1, \_2 ...
So insted of the pattern binding
`val (label, value) = pair`
one could also have written:

```
val label = pair._1
val value = pair._2
```

But the pattern matching form is generally preferred.
