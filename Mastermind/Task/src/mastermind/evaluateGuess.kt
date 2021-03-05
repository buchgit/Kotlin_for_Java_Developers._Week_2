package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    if (secret.isEmpty() or guess.isEmpty() or secret.isBlank() or guess.isBlank()) {
        Evaluation(0,0)
    }

    val rightPositions:Int = getRightPositions(secret,guess)
    val wrongPosition:Int = getWrongPositions(secret,guess)

    return Evaluation(rightPositions,wrongPosition)
}

fun getWrongPositions(secret: String, guess: String): Int {
    var wrongPosition = 0

    for (ch:Char in guess){
        if(secret.contains(ch,true)){
            wrongPosition++
        }
    }

    return wrongPosition
}

fun getRightPositions(secret: String,guess: String):Int{
    var rightPosition = 0

    for (index in guess.indices){
        if(secret[index]==guess[index]){
            rightPosition++
        }
    }

    return rightPosition
}
