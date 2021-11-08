package `merge-sort`

class MergeSort {
    fun sort(list: List<Int>): List<Int> {
        if (list.size == 1) return list

        var list1 = list.subList(0, list.size / 2)
        var list2 = list.subList(list.size / 2, list.size)

        if (list1.size > 1) {
            list1 = sort(list1)
        }
        if (list2.size > 1) {
            list2 = sort(list2)
        }
        return merge(list1, list2)
    }

    private fun merge(list1: List<Int>, list2: List<Int>): List<Int> {
        val result = mutableListOf<Int>()

        var list1Iterator = 0
        var list2Iterator = 0

        while (list1Iterator < list1.size || list2Iterator < list2.size) {

            if (list1Iterator >= list1.size) {
                val list2Item = list2[list2Iterator]
                result.add(list2Item)
                list2Iterator++
                continue
            }

            if (list2Iterator >= list2.size) {
                val list1Item = list1[list1Iterator]
                result.add(list1Item)
                list1Iterator++
                continue
            }

            val list1Item = list1[list1Iterator]
            val list2Item = list2[list2Iterator]

            if (list1Item < list2Item) {
                result.add(list1Item)
                list1Iterator++
                continue
            }

            if (list1Item > list2Item) {
                result.add(list2Item)
                list2Iterator++
                continue
            }
        }

        return result
    }

}
