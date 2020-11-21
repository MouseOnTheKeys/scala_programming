### Week 2

#### Lecture 2.3

***Scala Syntax Summary***

We have seen language elements to express types, expressions and definitions.
Below,we give their context-free syntax in Extended Backus-Nuar form (EBNF) where:
| denotes alternative,
[ ... ] an option (0 or 1),
{ ... } repetition (0 or more).

```
Type            = SimpleType | FunctionType
FunctionType    = SimpleType '=>' Type
                | '(' [Types] ')' '=>' Type
SimpleType      = Ident
Types           = Type {',' Type}
```
The ***type*** can be:
* A ***numeric type***: Int,Double(and Byte, Short, Char, Long, Float)
* The *Boolean* type with the values true and false,
* The *String* type,
* A ***function type***, like Int => Int,(Int, Int) => Int.

Later we will see more forms of types.

```
Expr            = InfixExpr | FunctionExpr
                | if '(' Expr ')' Expr else Expr
InfixExpr       = PrefixExp | InfixExpr Operator InfixExpr
Operator        = Indet
PrefixExpr      = ['+' | '-' | '!' | '~' ] SimpleExpr
SimpleExpr      = ident | literal | SimpleExp '.' ident | Block
FunctionExpr    = Bindings '=>' Expr
Bindings        = ident [':' SimpleType]
                | '(' [Binding {',' Binding}] ')'
Binding         = ident [':' Type]
Block           = '{' [Def ':'] Expr '}'
```
An *expression* can be:
* An ***indentifier*** such as x, *isGoodEnough*
* a ***literal***, like 0, 1.0, "abc"
* A ***function application***, like *sqrt(x)*
* An ***operator application***, like *math.abs*
* A ***conditional expression***, like *if (x<0) -x else x*
* A ***selection***, like *math.abs*
* A ***block***, like *{val x = math.abs(y) ; x * 2 }*
* An ***anonymous function***, like *x => x + 1*

A ***definition*** can be:
* A ***function definition***, like *def square(x: Int) = x\*x*
* A ***value definition***, like val y = square(2)

A ***parameter*** can be:
* A ***call-by-value parameter***, like *(x: Int)*,
* A ***call-by-name parameter***, like *(y: => Double)*
