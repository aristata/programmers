package aristata.programmers.d20190316

class ChangeInteger {

    fun solution(s: String): Int {
        return Integer.parseInt(s)
    }
}

fun main(args: Array<String>) {
    val changeInteger = ChangeInteger()

    val testCase1 = "1234"
    println(changeInteger.solution(testCase1))

    val testCase2 = "-1234"
    println(changeInteger.solution(testCase2))
}
