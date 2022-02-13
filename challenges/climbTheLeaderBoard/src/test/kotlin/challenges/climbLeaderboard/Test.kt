package challenges.climbLeaderboard


import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class Test {

    private val underTest = ClimbLeaderboard()

    @Test
    fun test() {
        val ranked = arrayOf(100, 100, 50, 40, 40, 20, 10)
        val players = arrayOf(5, 25, 50, 120)
        val result = underTest.climbingLeaderboard(ranked, players)
        val expected = arrayOf(6, 4, 2, 1)
        assertArrayEquals(expected, result)
    }

    @Test
    fun test2() {
        val ranked = arrayOf(100, 90, 90, 80, 75, 60)
        val players = arrayOf(50, 65, 77, 90, 102)
        val result = underTest.climbingLeaderboard(ranked, players)
        val expected = arrayOf(6, 5, 4, 2, 1)
        assertArrayEquals(expected, result)
    }

//    @Test
//    fun test3() {
//    }
//
//    @Test
//    fun test10() {
//    }


}
