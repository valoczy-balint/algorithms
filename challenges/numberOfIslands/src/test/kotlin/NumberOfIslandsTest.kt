package challenges.numberOfIslands

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class NumberOfIslandsTest {

    @Test
    fun test1() {
        val input = listOf(
            listOf(1, 1, 1, 0, 0),
            listOf(1, 1, 0, 0, 1),
            listOf(0, 0, 1, 0, 1),
            listOf(0, 0, 0, 0, 0),
            listOf(1, 1, 1, 1, 1)
        )
        val underTest = NumerOfIslands(input)
        Assertions.assertEquals(4, underTest.count())
    }
}
