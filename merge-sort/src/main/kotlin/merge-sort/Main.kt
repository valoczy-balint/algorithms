package `merge-sort`

fun main() {
    val list = listOf(3, 5, 2, 7, 9, 6)

    val mergeSort = MergeSort()

    val result = mergeSort.sort(list)

    println(result)
}
