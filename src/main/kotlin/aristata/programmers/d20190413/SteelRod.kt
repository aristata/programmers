package aristata.programmers.d20190413

import java.util.*

/**
 *  @author Aristata
 *  @date 2019-04-13
 *  @comment I hope you enjoy it every moment.
 */
class SteelRod {
    fun solution(arrangement: String): Int {
        var answer = 0

        // stack 생성
        val stack = Stack<Int>()

        // 전달받은 문자열을 반복함
        arrangement.forEachIndexed { index, it ->
            // '(' 이면 스택에 넣는다
            if ( it == '(' ) {
                stack.push(index)
            // ')' 이면 스택에서 뺀다
            } else if ( it == ')' ) {
                // '(' 다음에 ')'가 오면 스택에서 마지막껄 제거하고 현재까지의 스택 개수를 더한다.
                answer += if ( stack.peek() + 1  == index ) {
                    stack.pop()
                    stack.size

                // ')' 다음에 ')'가 오면 스택에서 마지막껄 제거하고 1만 더한다.
                } else {
                    stack.pop()
                    1
                }
            }
        }

        return answer
    }
}

fun main() {

    val steelRod = SteelRod()
    val result = steelRod.solution("()(((()())(())()))(())")
    println(result)
}