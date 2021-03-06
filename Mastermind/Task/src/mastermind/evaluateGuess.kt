package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

const val r: Char = 'r'
const val w: Char = 'w'

fun evaluateGuess(secret: String, guess: String): Evaluation {

    if (secret.isEmpty() or guess.isEmpty() or secret.isBlank() or guess.isBlank()) {
        Evaluation(0, 0)
    }

    return getCountOfPositions(secret, guess)

}

fun getCountOfPositions(secret: String, guess: String): Evaluation {

    var wrongPosition = 0
    var rightPosition = 0

    val map: MutableMap<Int, Char> = mutableMapOf()
    for (index in secret.indices) {
        map[index] = secret[index]
    }

    for (index in guess.indices) {
        if (guess[index] == secret[index]) {
            val previousPosition = map[index]
            map[index] = r
            if (previousPosition == w) {
                findWrongPosition(map, guess[index])
            }
            continue
        }
        findWrongPosition(map, guess[index])
    }

    for (value in map.values) {
        if (value == r) {
            rightPosition++
        } else if (value == w) {
            wrongPosition++
        }
    }

    return Evaluation(rightPosition, wrongPosition)
}

fun findWrongPosition(map: MutableMap<Int, Char>, char: Char) {
    for ((key, value) in map) {
        if (value == char) {
            map[key] = w
            break
        }
    }
}
