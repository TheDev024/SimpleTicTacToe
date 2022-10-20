fun main() {
    // put your code here
    // get user input
    val word = readln()
    for (letter in 'a'..'z') {
        if (word.contains(letter)) continue
        print(letter)
    }
}