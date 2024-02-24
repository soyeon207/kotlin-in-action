package chapter02.section2_5

import java.io.BufferedReader
import java.io.StringReader

fun main() {
    // 2.27 자바와 마찬가지로 try 사용하기
    val reader = BufferedReader(StringReader("239"))
    println(readNumber(reader))

    // 2.28 try 를 식으로 사용하기
    val reader2 = BufferedReader(StringReader("not a number"))
    println(readNumber2(reader2))

    // 2.29 catch 에서 값 반환하기
    val reader3 = BufferedReader(StringReader("not a number"))
    println(readNumber3(reader3))
}