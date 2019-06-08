package aristata.programmers.d20190511

import org.springframework.util.Assert

/**
 *  @author Aristata
 */
class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var totalTime = 1
        var currentWeight = 0
        val passedTruckList = mutableListOf<Int>()
        val passingTruckList = mutableListOf<PassingTruckOnBridge>()
        val waitingTruckList = truck_weights.toMutableList()

        // 다리를 지난 트럭 목록의 사이즈가 최초의 대기 트럭 사이즈와 같아질때 까지 반복합니다.
        while (passedTruckList.size < truck_weights.size) {

            // 한 사이클을 반복 할때 마다 시간을 1씩 증가 시킵니다.
            totalTime++

            // 다리 위에 트럭이 있는지 판단합니다.
            if (passingTruckList.isEmpty()) {
                // 다리 위에 트럭이 없으면 대기 중인 트럭 중 가장 앞의 트럭이 다리에 진입합니다.
                // 대기 중인 트럭 중 가장 앞의 트럭을 발췌하고 대기중인 트럭 목록에서 제거합니다.
                val frontInWaitingTruckList = waitingTruckList.removeAt(0)
                // 다리를 통과중인 트럭 목록에 추가합니다.
                passingTruckList += PassingTruckOnBridge(frontInWaitingTruckList, 0)
                // 현재 다리 위의 무게를 추가합니다.
                currentWeight += frontInWaitingTruckList
            } else {
                // 대기 중인 트럭 중 가장 앞의 트럭을 발췌합니다. 이때에는 아직 대기중인 트럭 목록에서 제거하지 않습니다.
                if (waitingTruckList.isNotEmpty()) {
                    val frontInWaitingTruckList = waitingTruckList.first()
                    // 가장 앞의 트럭이 다리에 진입 가능한지 판단합니다.
                    if (currentWeight + frontInWaitingTruckList <= weight) {
                        // 진입이 가능하면 대기 중인 트럭 중 가장 앞의 트럭을 발췌하고 대기중인 트럭 목록에서 제거합니다.
                        waitingTruckList.removeAt(0)
                        // 다리를 통과중인 트럭 목록에 추가합니다.
                        passingTruckList += PassingTruckOnBridge(frontInWaitingTruckList, 0)
                        // 현재 다리 위의 무게를 추가합니다.
                        currentWeight += frontInWaitingTruckList
                    }
                }
            }

            // 다리 위의 트럭을 한칸 전진 시킵니다.
            passingTruckList.map {
                it.position++
            }

            // 만약 다리를 통과한 트럭이 있으면, 다리를 통과 중인 트럭 목록에서 제거하고, 다리를 통과한 트럭 목록에 추가합니다.
            val passedTruck = passingTruckList.find {
                it.position >= bridge_length
            }
            if (passedTruck != null) {
                passingTruckList.remove(passedTruck)
                passedTruckList += passedTruck.weight
                currentWeight -= passedTruck.weight
            }
        }
        return totalTime
    }

}

data class PassingTruckOnBridge(
        var weight: Int,
        var position: Int
)

fun main() {

    val test = Solution()

    val bridge_length1 = 2
    val weight1 = 10
    val truck_weights1 = arrayOf(7, 4, 5, 6).toIntArray()
    val correctAnswer1 = 8

    val result1 = test.solution(bridge_length1, weight1, truck_weights1)
    println(result1)
    Assert.isTrue(correctAnswer1 == result1)

    val bridge_length2 = 100
    val weight2 = 100
    val truck_weights2 = arrayOf(10).toIntArray()
    val correctAnswer2 = 101

    val result2 = test.solution(bridge_length2, weight2, truck_weights2)
    println(result2)
    Assert.isTrue(correctAnswer2 == result2)

    val bridge_length3 = 100
    val weight3 = 100
    val truck_weights3 = arrayOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10).toIntArray()
    val correctAnswer3 = 110

    val result3 = test.solution(bridge_length3, weight3, truck_weights3)
    println(result3)
    Assert.isTrue(correctAnswer3 == result3)
}