fun main() {
    // write your code here
    val url = readln()
    val values = url.substringAfter("?").split("&")
    var password = ""
    for (value in values) {
        if (value.contains("pass")) {
            password = "password : " + if (value.substringAfter("=") == "") "not found" else value.substringAfter("=")
        }
        println(
            value.substringBefore("=") + " : " +
                    if (value.substringAfter("=") == "") "not found"
                    else value.substringAfter("=")
        )
    }
    print(password)
}