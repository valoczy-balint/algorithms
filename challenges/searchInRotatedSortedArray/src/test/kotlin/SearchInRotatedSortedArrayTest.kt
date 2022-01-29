package challenge.searchInRotatedSortedArrayTest

import challenges.searchInRotatedSortedArray.SearchInRotatedSortedArray
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SearchInRotatedSortedArrayTest {

    private val underTest = SearchInRotatedSortedArray()

    @Test
    fun test1() {
        val input = listOf(4, 5, 6, 7, 0, 1, 2)

        Assertions.assertEquals(0, underTest.find(input, 4))
        Assertions.assertEquals(1, underTest.find(input, 5))
        Assertions.assertEquals(2, underTest.find(input, 6))
        Assertions.assertEquals(3, underTest.find(input, 7))
        Assertions.assertEquals(4, underTest.find(input, 0))
        Assertions.assertEquals(5, underTest.find(input, 1))
        Assertions.assertEquals(6, underTest.find(input, 2))
        Assertions.assertEquals(-1, underTest.find(input, 3))
    }
}
