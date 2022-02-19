package challenges.validParentheses

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Test {

    @Test
    fun test1() {
        val result = countValidCombinations(3)
        assertEquals(
            5, result
        )
    }

    @Test
    fun test2() {
        val result = countValidCombinations(4)
        assertEquals(
            14, result
        )
    }
}
