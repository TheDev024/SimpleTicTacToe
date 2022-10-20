fun main() {
    // put your code here
    val string = readLine()
    var changed = string!!.replaceFirst(string[0], string[string.lastIndex])
    changed = changed.reversed()
    changed = changed.replaceFirst(changed[0], string[0])
    changed = changed.reversed()
    println(changed)
}