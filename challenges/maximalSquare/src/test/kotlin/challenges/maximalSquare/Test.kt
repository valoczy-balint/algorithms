package challenges.maximalSquare


import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Test {

    @Test
    fun test() {
        val input =
            arrayOf(
                charArrayOf('1', '0', '1', '0', '0'),
                charArrayOf('1', '0', '1', '1', '1'),
                charArrayOf('1', '1', '1', '1', '1'),
                charArrayOf('1', '0', '0', '1', '0')
            )

        val underTest = Solution()
        val result = underTest.maximalSquare(input)
        assertEquals(4, result)
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
