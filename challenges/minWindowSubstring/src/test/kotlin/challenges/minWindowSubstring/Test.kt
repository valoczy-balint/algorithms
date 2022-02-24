package challenges.minWindowSubstring


import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Test {

    private val underTest = MinWindowSubstring()

    @Test
    fun test() {
        val input = "CEABEBA"
        val target = "ABCA"
        val result = underTest.min(input, target)
        Assertions.assertEquals(7, result)
    }

    @Test
    fun test2() {
        val input = "ABCADECEBAC"
        val target = "ABCA"
        val result = underTest.min(input, target)
        Assertions.assertEquals(4, result)
    }

    @Test
    fun test3() {
        val input = "ABCADECEBAC"
        val target = "ABCADECEBAC"
        val result = underTest.min(input, target)
        Assertions.assertEquals(11, result)
    }

    @Test
    fun test4() {
        val input = ""
        val target = "ABCADECEBAC"
        val result = underTest.min(input, target)
        Assertions.assertEquals(0, result)
    }

    @Test
    fun test5() {
        val input = "ABCADECEBAC"
        val target = ""
        val result = underTest.min(input, target)
        Assertions.assertEquals(0, result)
    }

    @Test
    fun test6() {
        val input = "ABCADECEBAC"
        val target = "K"
        val result = underTest.min(input, target)
        Assertions.assertEquals(-1, result)
    }
}
