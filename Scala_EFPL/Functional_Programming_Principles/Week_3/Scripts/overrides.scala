object overrides {

}

abstract class Base {
    def foo = 1
    def bar : Int
}

class Sub extends Base {
    override def foo = 2 // override is must in Scala  to be sure twhat we want to override
    def bar = 3 // for methods that implement definitions in base classes the override is optional
}