### Week 5

#### Lecture 5.1 - Functions on Lists

**_List Methods_**

```
xs.length       The number of elements of xs.
xs.last         The list's last elements, exception if list is empty
xs.init         A list cinsisting of elements of xs except the last one, exception if list is empty
xs take n       A list consisting of the first n elements of xs, or xsitself ig it is shother than n.
xs drop n       The rest of the collection after takking n elements
xs(n)           (or. etitten out, xs apply n). Te element of xs at the index n.
```

**_Creting new lists:_**

```
xs ++ ys            The list consisting of all elements of xs followed by all elements of ys.
xs.reverse          The list containing the elements of xs in reversed order.
xs updated (n, x)   Thr list containing the same elements as xs, except at index n where it contains x.
```

**_Finding eleements:_**

```
xs indexOf x        The index of the first element is xs equal to x, or -1 if x does not appear in xs.
xs contains x       same as xs indexOf x >= 0
```

Impleementation of last:

The complexy of head is (small) constant time.
What is complexity of last?

```Scala
def last[T](xs: List[T]): T= xs match {
    case List() => throw new Error("last of empty list")
    case List{x} =>
    case y :: ys => last(ys)
}
```

So, last takes stepls proportionall to the length of the list xs. >We need to take one recursion for each element of the list.

Implementation of init as external function:

```Scala
def init[t](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("init of empty list")
    case List(x) => List()
    case y :: ys => y :: init(ys)
}
```

Implementation of contcatination: (xs ::: ys = ys.:::(xs))

```Scala
def concat[T](xs: List[T], ys: List[T]) = xs match {
    case List() => ys
    case z :: zs => z :: concat(zs, ys)
}
```

Complexity ???
|xs| coresponds to the length of list xs
