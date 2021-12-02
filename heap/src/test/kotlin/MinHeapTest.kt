import heap.MinHeap
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinHeapTest {

    @Test
    fun test() {
        val input = listOf(1, 5, 8, 4, 6, 3, 2)
        val heap = MinHeap<Int>()

        input.forEach { heap.insert(it) }

        assertEquals(listOf(1,4,2,5,6,8,3), heap.list)

        assertEquals(1, heap.delete())
        assertEquals(listOf(2,4,3,5,6,8), heap.list)

        assertEquals(2, heap.delete())
        assertEquals(listOf(3,4,8,5,6), heap.list)
    }
}
