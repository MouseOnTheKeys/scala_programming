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
