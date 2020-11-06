// we replace println call with print call so all arguments will bhe printed on the same line.
var i = 0
while (i < args.length) {
    if (i != 0) // you must put boolean expresion for while or an if in parentheses. if (i < 10) !!! MUST !!!
        print(" ")
    print(args(i))
    i += 1
}
println()

/* we can write code like this

var i = 0;
while (i<args.length) {
    if(i != 0) {
        print(" ");
    }
    print(args(i));
    i += 1;
}
println();

*/
// This is imperative style of programming
