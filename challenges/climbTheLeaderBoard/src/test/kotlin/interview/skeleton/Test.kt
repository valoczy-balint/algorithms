package interview.skeleton


import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Test {

    private val climbLeaderboard = ClimbLeaderboard()

    @Test
    fun test() {
        val ranked = arrayOf(100, 100, 50, 40, 40, 20, 10)
        val players = arrayOf(5, 25, 50, 120)
        val result = climbLeaderboard.climbingLeaderboard(ranked, players)
        val expected = arrayOf(6, 4, 2, 1)
        assertEquals(expected, result)
    }

    @Test
    fun test2() {
    }

    @Test
    fun test3() {
    }

    @Test
    fun test10() {
    }


}
