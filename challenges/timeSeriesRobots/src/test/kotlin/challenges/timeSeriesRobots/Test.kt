package challenges.timeSeriesRobots

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class Test {
    private val underTest = TimeSeriesRobots()

    @Test
    fun test1() {
        val input = arrayOf(
            arrayOf(1, 0, 1, 0),
            arrayOf(1, 1, 0, 0),
            arrayOf(0, 1, 1, 0),
            arrayOf(1, 0, 0, 1),
            arrayOf(0, 1, 1, 0),
            arrayOf(0, 1, 1, 0),
            arrayOf(1, 0, 1, 0)
        )

        assertTrue(underTest.isValidTimeSeries(input, 2))
    }

    @Test
    fun test2() {
        val input = arrayOf(
            arrayOf(1, 0, 1, 0),
            arrayOf(1, 1, 0, 0),
            arrayOf(0, 1, 0, 1),
        )

        assertFalse(underTest.isValidTimeSeries(input, 2))
    }

    @Test
    fun test3() {
        val input = arrayOf(
            arrayOf(1, 0, 1, 1),
            arrayOf(1, 1, 0, 1),
            arrayOf(0, 1, 1, 0),
        )

        assertFalse(underTest.isValidTimeSeries(input, 3))
    }
}
