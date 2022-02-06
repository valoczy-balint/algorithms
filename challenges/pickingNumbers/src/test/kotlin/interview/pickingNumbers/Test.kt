package interview.pickingNumbers


import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Test {
    private val underTest = PickingNumbers()

    @Test
    fun test() {
        val input = arrayOf(1, 1, 2, 2, 4, 4, 5, 5, 5)
        Assertions.assertEquals(5, underTest.pickingNumbers(input))
    }

    @Test
    fun test2() {
        val input = arrayOf(4, 6, 5, 3, 3, 1)
        Assertions.assertEquals(3, underTest.pickingNumbers(input))
    }

}
