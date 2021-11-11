package heap

import tree.BinaryNode


fun main() {

    val root = BinaryNode(3)

    val minHeap = MinHeap(root)

    minHeap.insert(4)
    minHeap.insert(6)
    minHeap.insert(3)
    minHeap.insert(5)
    minHeap.insert(7)
    minHeap.insert(1)
    minHeap.insert(8)
    minHeap.insert(2)


    println(minHeap)
}
