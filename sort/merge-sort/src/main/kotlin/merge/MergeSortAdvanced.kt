package merge

import kotlin.math.min

class MergeSortAdvanced {
    fun sort(list: List<Int>, sublistCount: Int): List<Int> {
        if (list.size == 1) return list

        val subLists = mutableListOf<List<Int>>()
        val subListSize = list.size / sublistCount

        for (i in 0 until sublistCount) {
            val startIndex = i * subListSize
            var endIndex = i * subListSize + subListSize

            // Adding the remaining elements to the last list
            if (list.size - endIndex < subListSize) {
                endIndex = list.size
            }

            subLists.add(list.subList(startIndex, endIndex))
        }

        for (i in 0 until subLists.size) {
            val subList = subLists[i]
            if (subList.size > 1) {
                subLists[i] = sort(subList, sublistCount)
            }
        }

        return merge(subLists)
    }

    private fun merge(lists: List<List<Int>>): List<Int> {
        val result = mutableListOf<Int>()

        val iterators = mutableListOf<Int>()
        lists.forEach { _ -> iterators.add(0) }


        while (unsortedElementsExist(lists, iterators)) {

            val itemsToCompare = mutableListOf<Int>()

            for (i in 0 until iterators.size) {
                val iterator = iterators[i]
                val list = lists[i]

                if (iterator < list.size) {
                    val item = list[iterator]
                    itemsToCompare.add(item)
                }
            }

            val minimum = findMinimum(itemsToCompare)

            for (i in 0 until iterators.size) {
                val iterator = iterators[i]
                val list = lists[i]
                if (iterator < list.size) {
                    val item = list[iterator]

                    if (minimum == item) {
                        result.add(item)
                        iterators[i]++
                        break
                    }
                }
            }
        }

        return result
    }

    private fun unsortedElementsExist(lists: List<List<Int>>, iterators: MutableList<Int>): Boolean {
        for (i in 0 until iterators.size) {
            val iterator = iterators[i]
            val list = lists[i]

            if (iterator < list.size) {
                return true
            }
        }
        return false
    }

    private fun findMinimum(items: List<Int>) = items.reduce { acc, i -> min(acc, i) }
}
