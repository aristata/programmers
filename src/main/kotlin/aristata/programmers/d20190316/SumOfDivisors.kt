package aristata.programmers.d20190316

class SumOfDivisors {

    fun solution(num: Int): Int {
        var answer = 0
        for (i in 1..num) {
            if (num % i == 0)
                print("$i ")
            answer += i
        }
        return answer
    }
}

fun main(args: Array<String>) {
    val a = SumOfDivisors()
    val result = a.solution(12)
    println()
    println(result)
}
