package `merge-sort`

import kotlin.system.measureTimeMillis

fun main() {

    val list = mutableListOf<Int>()

    for (i in 0..100000) {
        list.add(i)
    }

    list.shuffle()

    val mergeSortAdvanced = MergeSortAdvanced()
    val mergeSort = MergeSort()

    println(
        "Normal : ${
            measureTimeMillis {
                mergeSort.sort(list)
            }
        }"
    )

    println(
        "Advanced: ${
            measureTimeMillis {
                mergeSortAdvanced.sort(list, 50) //TODO with 6 splits the performance is abysmal
            }
        }"
    )

}
