package heap

import tree.BinaryNode

fun main() {

    val root = BinaryNode(6)

    val minHeap = MinHeap(root)

    minHeap.insert(12)
    minHeap.insert(23)
    minHeap.insert(34)
    minHeap.insert(87)
    minHeap.insert(71)
    minHeap.insert(56)
    minHeap.insert(92)

    println(minHeap)

    println(minHeap.delete())
    println(minHeap.delete())
    println(minHeap.delete())
    println(minHeap.delete())

    println(minHeap)
}
