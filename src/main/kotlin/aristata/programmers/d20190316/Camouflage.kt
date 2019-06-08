package aristata.programmers.d20190316

class Camouflage {

    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1

        val clothMap = mutableMapOf<String, Int>()
        clothes.forEach {
            clothMap[it[1]] = clothMap.getOrDefault(it[1], 0) + 1
        }
        for (count in clothMap.values) {
            answer *= (count + 1)
        }

        return answer - 1
    }
}

fun main(args: Array<String>) {

    val testCase1 = arrayOf(
            arrayOf("yellow_hat", "headgear"),
            arrayOf("blue_sunglasses", "eyewear"),
            arrayOf("green_turban", "headgear")
    )

    val testCase2 = arrayOf(
            arrayOf("crow_mask", "face"),
            arrayOf("blue_sunglasses", "face"),
            arrayOf("smoky_makeup", "face")
    )

    val camouflage = Camouflage()
    val result = camouflage.solution(testCase1)
    println("결과: $result")

    val result2 = camouflage.solution(testCase2)
    println("결과2: $result2")
}

