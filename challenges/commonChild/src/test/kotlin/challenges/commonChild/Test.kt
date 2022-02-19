package challenges.commonChild


import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Test {

    val underTest = CommonChild()

    @Test
    fun test() {
        val result = underTest.commonChild("HARRY", "SALLY")
        Assertions.assertEquals(2, result)
    }

    @Test
    fun test2() {
        val result = underTest.commonChild("ABCDAF", "ACBCF")
        Assertions.assertEquals(4, result)
    }
}
