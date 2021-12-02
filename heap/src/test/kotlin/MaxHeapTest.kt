import heap.MaxHeap
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxHeapTest {

    @Test
    fun test() {
        val input = listOf<Int>(1, 5, 8, 4, 6, 3, 2)
        val heap = MaxHeap<Int>()

        input.forEach { heap.insert(it) }

        assertEquals(listOf(8, 6, 5, 1, 4, 3, 2), heap.list)

        assertEquals(8, heap.delete())
        assertEquals(listOf(6, 4, 5, 1, 2, 3), heap.list)

        assertEquals(6, heap.delete())
        assertEquals(listOf(5, 4, 3, 1, 2), heap.list)
    }
}
