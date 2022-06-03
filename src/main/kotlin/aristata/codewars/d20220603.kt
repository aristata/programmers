object Kata {
    fun digitize(n:Long):IntArray {

        // Code here
        return n.toString().chunked(1).map { it.toInt() }.reversed().toIntArray()
    }
}

fun main() {

    val result = Kata.digitize(0)
    result.map { println(it) }
}
