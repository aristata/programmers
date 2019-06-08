package aristata.programmers.d20190427

import org.springframework.util.Assert

/**
 *  @author Aristata
 */
class 프린터 {

    data class PrioritiesWithIndex(
            val index: Int,
            val priority: Int
    )

    fun solution(priorities: IntArray, location: Int): Int {

        // 인덱스가 포함된 리스트
        val prioritiesWithIndex = priorities.mapIndexed { index, i ->
            PrioritiesWithIndex(index, i)
        }.toMutableList()

        // 새롭게 정렬될 배열
        var answerArray = arrayOf<PrioritiesWithIndex>()

        while ( prioritiesWithIndex.size > 0 ) {
            // 첫번째를 꺼낸다.
            val front =  prioritiesWithIndex.removeAt(0)

            val haveBigger = prioritiesWithIndex.find {
                it.priority > front.priority
            } != null

            if (haveBigger) {
                // 우선순위가 높은 문서가 있으면
                prioritiesWithIndex += front
            } else {
                // 우선순위가 높은 문서가 없으면
                answerArray += front
            }
        }

        val ours = answerArray.find {
            it.index == location
        }

        return answerArray.indexOf(ours) + 1
    }
}

fun main() {

    val test = 프린터()

    val priorities1 = arrayOf(2, 1, 3, 2).toIntArray()
    val location1 = 2
    val correctAnswer1 = 1

    val result1 = test.solution(priorities1, location1)
    Assert.isTrue(correctAnswer1 == result1)

    val priorities2 = arrayOf(1, 1, 9, 1, 1, 1).toIntArray()
    val location2 = 0
    val correctAnswer2 = 5

    val result2 = test.solution(priorities2, location2)
    Assert.isTrue(correctAnswer2 == result2)
}
