package heap

import tree.BinaryNode

/**
 * Not concurrent
 */
class MaxHeap<T : Comparable<T>>(
    val list: MutableList<T> = mutableListOf(), override val size: Int = 0
) : Collection<T> {

    private fun parentIndex(i: Int) = (i - 1) / 2
    private fun hasParent(i: Int) = parentIndex(i) >= 0
    private fun parent(i: Int): T = list[parentIndex(i)]

    private fun leftChildIndex(i: Int) = (i * 2) + 1
    private fun hasLeftChild(i: Int) = leftChildIndex(i) < list.size
    private fun leftChild(i: Int): T = list[leftChildIndex(i)]

    private fun rightChildIndex(i: Int) = (i * 2) + 2
    private fun hasRightChild(i: Int) = rightChildIndex(i) < list.size
    private fun rightChild(i: Int): T = list[rightChildIndex(i)]

    fun delete(): T {
        val result = list[0]
        list[0] = list[list.size - 1]
        list.removeAt(list.size - 1)

        var index = 0
        while (true) {
            if (hasLeftChild(index) && hasRightChild(index)) {
                val leftChild = leftChild(index)
                val rightChild = rightChild(index)
                val current = list[index]

                index = if (leftChild > rightChild) {
                    if (leftChild > current) {
                        swap(leftChildIndex(index), index)
                        leftChildIndex(index)
                    } else {
                        break
                    }
                } else {
                    if (rightChild > current) {
                        swap(rightChildIndex(index), index)
                        rightChildIndex(index)
                    } else {
                        break
                    }
                }
            } else if (hasLeftChild(index)) {
                if (leftChild(index) > list[index]) {
                    swap(leftChildIndex(index), index)
                    index = leftChildIndex(index)
                } else {
                    break
                }
            } else {
                break
            }
        }
        return result
    }

    fun insert(value: T) {
        list.add(value)

        var index = list.size - 1

        while (index > 0) {
            val item = list[index]
            if (item > parent(index)) {
                swap(index, parentIndex(index))
                index = parentIndex(index)
            } else {
                break
            }
        }
    }

    private fun swap(index1: Int, index2: Int) {
        val temp = list[index1]
        list[index1] = list[index2]
        list[index2] = temp
    }

    private fun swap(node1: BinaryNode<T>, node2: BinaryNode<T>) {
        val temp = node1.value
        node1.value = node2.value
        node2.value = temp
    }

    override fun toString() = list.toString()

    override fun contains(element: T) = list.contains(element)

    override fun containsAll(elements: Collection<T>) = list.containsAll(elements)

    override fun isEmpty() = list.isEmpty()

    override fun iterator() = list.iterator()
}
