fun main() {
    // write your code here
    val numOfCompanies = readln().toInt()

    val incomes = mutableListOf<Int>()
    for (i in 0 until numOfCompanies) incomes += readln().toInt()

    val percents = mutableListOf<Int>()
    for (i in 0 until numOfCompanies) percents += readln().toInt()

    val taxes = mutableListOf<Float>()
    for (i in 0 until numOfCompanies) taxes += incomes[i].toFloat() * percents[i].toFloat() / 100f

    var maxTaxIndex = 0
    for (tax in taxes) if (tax > taxes[maxTaxIndex]) maxTaxIndex = taxes.indexOf(tax)

    println(maxTaxIndex + 1)
}
