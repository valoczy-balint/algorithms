package challenges.gasStation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Test {

    private val underTest = GasStation()

    @Test
    fun test1() {
        val gas = arrayOf(2,3,4)
        val cost = arrayOf(3,4,3)

        val result = underTest.canCompleteCircuit(gas.toIntArray(), cost.toIntArray())
        assertEquals(-1, result)
    }

    @Test
    fun test2() {
        val gas = arrayOf(1,2,3,4,5)
        val cost = arrayOf(3,4,5,1,2)

        val result = underTest.canCompleteCircuit(gas.toIntArray(), cost.toIntArray())
        assertEquals(3, result)
    }
}
