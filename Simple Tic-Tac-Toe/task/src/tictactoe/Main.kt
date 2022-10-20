package tictactoe

enum class Result {
    X_WINS, O_WINS, DRAW
}

fun main() {

    // declare the grid
    val grid = mutableListOf<MutableList<String>>()

    /**
     * Outputs current grid state to the console
     */
    fun outputGrid() {
        val pattern = "---------"
        println(pattern)
        for (row in grid) {
            print("|")
            for (item in row) print(if (item == "_") "  " else " $item")
            println(" |")
        }
        println(pattern)
    }

    // initialize a 3 x 3 empty grid
    for (i in 0..2) {
        grid.add(mutableListOf())
        for (j in 0..2) {
            grid[i] += "_"
        }
    }

    outputGrid()

    // create a variable to define current turn
    var turn = "X"

    // numbers of current Xs and Os
    var countX: Int
    var countO: Int

    // final result of the game
    val result: Result

    // the game loop
    game@while (true) {
        // prompt the user to make a move
        input@while (true){
            // get coordinates to make a move
            val coordinates = readln()

            // check validity of the move
            if (!(coordinates[0].isDigit() && coordinates[2].isDigit())) {
                println("You should enter numbers!")
            } else {
                val coordX = coordinates.substringBefore(" ").toInt()
                val coordY = coordinates.substringAfter(" ").toInt()
                if (coordX !in 1..3 || coordY !in 1..3) {
                    println("Coordinates should be from 1 to 3!")
                } else if (grid[coordX - 1][coordY - 1] != "_") {
                    println("This cell is occupied! Choose another one!")
                } else {
                    grid[coordX - 1][coordY - 1] = turn
                    break
                }
            }
        }

        outputGrid()

        // reset counts to 0
        countX = 0; countO = 0

        // count Xs and Os again
        for (row in grid) for (item in row)
            if (item == "X") countX += 1 else if (item == "O") countO += 1

        var count: Int
        var countRL = 0
        var countLR = 0

        for (i in 0..2) {
            count = 0
            for (j in 0..2)
                if (grid[i][j] == turn) count += 1
            if (count == 3) {
                result = if (turn == "X") Result.X_WINS else Result.O_WINS
                break@game
            } else count = 0

            for (j in 0..2)
                if (grid[j][i] == turn) count += 1
            if (count == 3) {
                result = if (turn == "X") Result.X_WINS else Result.O_WINS
                break@game
            }

            if (grid[i][i] == turn) countLR += 1
            if (grid[i][2 - i] == turn) countRL += 1
        }
        if (countRL == 3 || countLR == 3) {
            result = if (turn == "X") Result.X_WINS else Result.O_WINS
            break
        }

        if (countX + countO == 9) {
            result = Result.DRAW
            break
        }

        // change turn
        turn = if (turn == "X") "O" else "X"
    }

    // output the result
    println(
        when (result) {
            Result.X_WINS -> "X wins"
            Result.O_WINS -> "O wins"
            else -> "Draw"
        }
    )
}