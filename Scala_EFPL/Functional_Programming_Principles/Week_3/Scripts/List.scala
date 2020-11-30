package week4

import java.{util => ju}

trait List[T] {
    def isEmpty: Boolean
    def head: T
    def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
    def isEmpty = false
}
/*
val is evaluated when the object is first initioalised, while def is evaluated each time it is referenced
*/
class Nil[T] extends List[T] {
    def isEmpty: Boolean = true
    def head: Nothing = throw new ju.NoSuchElementException("Nil.head")
    def tail: Nothing = throw new ju.NoSuchElementException("Nil.tail")
}

