package challenges.magicSquare


import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Test {

    private val underTest = MagicSquare()

    @Test
    fun test() {
        val input = arrayOf(
            arrayOf(5, 3, 4),
            arrayOf(1, 5, 8),
            arrayOf(6, 4, 2)
        )

        assertEquals(7, underTest.formingMagicSquare(input))
    }
}
