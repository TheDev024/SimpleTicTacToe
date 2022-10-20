fun main() {
    // put your code here
    // get the usr input
    val combination = readln()
    for (char in combination) {
        if (char.isDigit()) {
            println(char)
            break
        }
    }
}