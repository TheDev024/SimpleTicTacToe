fun main() {
    // write your code here
    val size = readln().toInt()

    val numbers = mutableListOf<Int>()
    for (i in 0 until size) numbers += readln().toInt()

    var count = 0
    for (i in 2 until size) if (numbers[i] - numbers[i - 1] == 1 && numbers[i - 1] - numbers[i - 2] == 1) count += 1

    println(count)
}