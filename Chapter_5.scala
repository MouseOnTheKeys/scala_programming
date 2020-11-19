// BASIC TYPES AND OPERATIONS

val hex = 0x5
val hex2 = 0x00FF
val magic = 0xcafebabe

val dec = 31
val dec1 = 255

val prog = 0XCAFEBABEL // if integer literal ends with L its long otherwise Int
val tower = 35L

// If an Int literal is assigned to variable short or byte the literal is treted as it is short or byte type so long as the literal value is in range of that type
val little: Short = 367
val littler: Byte = 38

// Floating point literals
val big = 1.23456
val bigger = 1.2345e2 // exponent 10^2
val biggerStill = 1.234E45

val little = 1.2345F //if floating point ends with F or f,  it is float not double
val littleBigger = 3e5F

// Character literals
val a = 'A'
val d = '\u0041'
val f = '\u0044'
val B\u0041\u0044 = 1

val backslash = '\\'
val hello = "Hello" // String
println("""Scala includes a special syntax,
for raw strings.""")
println("""|Welcome to Scala Programming.
           |By MouseOnTheKeys 2020""".stripMargin)

// Symbol Literals
//'ident
updateRecordByName('favoriteAlbum, "OK Computer")
// there is not much we can do with symbol exept find out its name.
val s = `aSymbol
val nm = s.name

//String Interpolation
/*
Scala includes a flexible mechanism for string interpolation, which allows
you to embed expressions within string literals. Its most common use case is
to provide a concise and readable alternative to string concatenation
*/
val name = "reader"
println(s"Hello, $name !")
/*
The expression, s"Hello, $name!" is a processed string literal. Be-
cause the letter s immediately precedes the open quote, Scala will use the s
string interpolator to process the literal. The s interpolator will evaluate each
embedded expression, invoke toString on each result, and replace the em-
bedded expressions in the literal with those results. Thus s"Hello, $name!"
yields "Hello, reader!" , the same result as "Hello, " + name + "!" .
*/
s"The answer is ${6 * 7}."
// Scala provides two other string interpolators by default: raw and f .
println(raw"No\\\\escape!") // prints: No\\\\escape!
f"${math.Pi}%.5f" // The f string interpolator allows you to attach printf -style formatting instructions to embedded expressions.
/*
In Scala, string interpolation is implemented by rewriting code at com-
pile time. The compiler will treat any expression consisting of an identifier
followed immediately by the open double quote of a string literal as a string
interpolator expression. The s , f , and raw string interpolators are imple-
mented via this general mechanism.
*/

// Operators are Methods

val dum = 1+2
val sumMore = 1.+(2) // same expressions

/*
In fact, Int contains several overloaded + methods that take different
parameter types. The + symbol is an operator—an infix operator to be specific. Operator
notation is not limited to methods like + that look like operators in other
languages.*/
val s = "Hello, world !"

s indexOf 'o' // Scala invokes s.indexOf('o')
s indexOf ('o', 5) // Scala invokes s.indexOf('o', 5)
/*
Any method can be an operator.
In Scala operators are not special language syntax; any method can
be an operator. What makes a method an operator is how you use it.
When you write “ s.indexOf('o') ”, indexOf is not an operator. But
when you write “ s indexOf 'o' ”, indexOf is an operator, because
you’re using it in operator notation.
*/
/*
Scala also has two other
operator notations: prefix and postfix. In prefix notation, you put the method
name before the object on which you are invoking the method (for example,
the ‘ - ’ in -7 ). In postfix notation, you put the method after the object (for
example, the “ toLong ” in “ 7 toLong ”).
*/
(2.0).unary_-
// The only identifiers that can be used as prefix operators are + , - , ! , and ~ .

/*
Postfix operators are methods that take no arguments, when they are in-
voked without a dot or parentheses. In Scala, you can leave off empty paren-
theses on method calls. The convention is that you include parentheses if the
method has side effects, such as println() , but you can leave them off if
the method has no side effects, such as toLowerCase invoked on a String :
*/
val s = "Hello, SCALA !!!"
s.toLowerCase

//Aritmethic Operations

1.2+2.3
3 - 1
'b' - 'a'
2L * 3L
11 / 4
11.0f / 4.0f
11 % 4

/*
When both the left and right operands are integral types ( Int , Long ,
Byte , Short , or Char ), the / operator will tell you the whole number por-
tion of the quotient, excluding any remainder. The % operator indicates the
remainder of an implied integer division.
*/

val neg = 1 + -3
val y = +3
-neg

// Relational and Logical operations

1 > 2
1 < 2
1.0 <= 1.0
3.5f >= 3.6f
'a' >= 'A'
val untrue = !true

// Logical methods

val toBe = true
val question = toBe || !toBe
val paradox = toBe && !toBe

def salt() = {println("salt"); false}

def pepper() = {println("pepper"); true}

pepper() && salt()

salt() && pepper()
/*
In the first expression, pepper and salt are invoked, but in the second, only
salt is invoked. Given salt returns false , there’s no need to call pepper .
*/

// Bitwise Operators

/*
Scala enables you to perform operations on individual bits of integer types
with several bitwise methods. The bitwise methods are: bitwise-and ( & ),
bitwise-or ( | ), and bitwise-xor ( ˆ ). 5 The unary bitwise complement operator
( ~ , the method unary_ ~ ) inverts each bit in its operand.
*/

1 & 2 // 1 & 2 , bitwise-ands each bit in 1 (0001) and 2 (0010), which yields 0 (0000)
1 | 2 // 1 | 2 , bitwise-ors each bit in the same operands, yielding 3 (0011)
1 ^ 3 // ˆ 3 , bitwisexors each bit in 1 (0001) and 3 (0011), yielding 2 (0010)
~1 // ~1 , inverts each bit in 1 (0001), yielding -2, which in binary looks like 11111111111111111111111111111110

-1 >> 31 // Int -1
-1 >>> 31 // Int 1
1 << 2 // Int 4

/*
-1 in binary is 11111111111111111111111111111111. In the first ex-
ample, -1 >> 31 , -1 is shifted to the right 31 bit positions. Since an Int
consists of 32 bits, this operation effectively moves the leftmost bit over un-
til it becomes the rightmost bit. 6 Since the >> method fills with ones as it
shifts right, because the leftmost bit of -1 is 1, the result is identical to the
original left operand, 32 one bits, or -1. In the second example, -1 >>> 31 ,
the leftmost bit is again shifted right until it is in the rightmost position, but
this time filling with zeroes along the way. Thus the result this time is binary
00000000000000000000000000000001, or 1. In the final example, 1 << 2 ,
the left operand, 1, is shifted left two positions (filling in with zeroes), re-
sulting in binary 00000000000000000000000000000100, or 4.
*/

// Object equality

1 == 2
1 != 2
2 == 2

// These operations apply to objects
List(1, 2, 3) == List(1, 2, 3)
List(1, 2, 3) == null

("he" + "llo") == "hello"

// Operator precedance and associativity

/*
Operator precedence determines which parts of an expression are evaluated
before the other parts.
*/
2 << 2 + 2
2 + 2 << 2

x *= y + 1 // same as x *= (y + 1)

/*
When multiple operators of the same precedence appear side by side in
an expression, the associativity of the operators determines the way operators
are grouped. The associativity of an operator in Scala is determined by its
last character.

This associativity rule also plays a role when multiple operators of the
same precedence appear side by side. If the methods end in ‘ : ’, they are
grouped right to left; otherwise, they are grouped left to right.

a ::: b ::: c is treated as a ::: (b ::: c) . But a * b * c , by contrast, is
treated as (a * b) * c
*/