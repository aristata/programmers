package aristata.programmers.d20190608

/**
 *  @author Aris Jang
 */
fun main() {

    val testCase1 = arrayOf(6, 9, 5, 7, 4).toIntArray()
    val testCase2 = arrayOf(3, 9, 9, 3, 5, 7, 2).toIntArray()
    val testCase3 = arrayOf(1, 5, 3, 6, 7, 6, 5).toIntArray()

    val test = Solution()
    val result1 = test.solution(testCase1).toList()
    println(result1)
    val result2 = test.solution(testCase2).toList()
    println(result2)
    val result3 = test.solution(testCase3).toList()
    println(result3)
}

class Solution {
    fun solution(heights: IntArray): IntArray {
        val towerList = heights.mapIndexed { index, i -> Tower(i, index + 1, 0) }
        val reversedTowerList = towerList.reversed()
        val stack = reversedTowerList.toMutableList()

        return reversedTowerList.map { tower ->
            val foundTower = stack.firstOrNull { tower2 -> tower.height < tower2.height }
            stack.remove(tower)
            tower.copy( receptionIndex = foundTower?.index ?: 0 )
        }.map {
            it.receptionIndex
        }.reversed().toIntArray()
    }
}

data class Tower(
        val height: Int,
        val index: Int,
        val receptionIndex: Int
)