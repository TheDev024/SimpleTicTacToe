fun main() {
    // write your code here
    val string = readln()
    var G = 0; var C = 0
    for (character in string) if (character.lowercase() == "c") C += 1 else if (character.lowercase() == "g") G += 1
    val percent = (G + C) / string.length.toDouble() * 100
    println(percent)
}