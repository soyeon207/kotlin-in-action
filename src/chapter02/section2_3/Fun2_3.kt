package chapter02.section2_3

import chapter02.section2_3.Color2.*

fun getMnemonic(color: Color2) = when (color) {
    RED -> "Richard"
    ORANGE -> "Of"
    YELLOW -> "York"
    GREEN -> "Gave"
    BLUE -> "Battle"
    INDIGO -> "In"
    VIOLET -> "Vain"
}

fun getWarmth(color: Color2) = when(color) {
    RED, ORANGE, YELLOW -> "warm"
    GREEN -> "neutral"
    BLUE, INDIGO, VIOLET -> "cold"
}

fun mix(c1: Color2, c2: Color2) =
    when (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Dirty color")
    }

fun mixOptimized(c1: Color2, c2: Color2) =
    when {
        (c1 == RED && c2 == YELLOW) ||
                (c1 == YELLOW && c2 == RED) ->
                    ORANGE
        (c1 == YELLOW && c2 == YELLOW) ||
                (c1 == BLUE && c2 == YELLOW) ->
                    GREEN
        (c1 == BLUE && c2 == VIOLET) ||
                (c1 == VIOLET && c2 == BLUE) ->
                    INDIGO
        else -> throw Exception("Dirty color")
    }


fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num
        return n.value
    }
    if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}

fun eval2(e: Expr): Int = when (e) {
    is Num ->
        e.value

    is Sum ->
        eval2(e.right) + eval2(e.left)

    else ->
        throw IllegalArgumentException("Unknown expression")
}

fun evalWithLogging(e: Expr): Int =
    when (e) {
        is Num -> {
            println("num : ${e.value}")
            e.value
        }

        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum : $left + $right")
            left + right
        }

        else -> throw IllegalArgumentException("Unknown expression")
    }

