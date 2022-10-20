fun main() {
    // write your code here
    // get size of the list
    val size = readln().toInt()

    // get items of the list
    val numbers = mutableListOf<Int>()
    for (i in 0 until size) numbers += readln().toInt()

    // get p and m values
    val pm = readln()
    val p = pm.split(" ")[0].toInt()
    val m = pm.split(" ")[1].toInt()

    checkPM(numbers, p, m)
}

fun checkPM(list: MutableList<Int>, p: Int, m: Int) {
    for (i in 1 until list.size) if (
        list[i] == p && list[i - 1] == m || list[i] == m && list[i - 1] == p
    ) {
        println("NO")
        return
    }
    println("YES")
}