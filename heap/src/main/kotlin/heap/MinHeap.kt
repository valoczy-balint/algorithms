package heap

import tree.BinaryNode
import java.util.LinkedList

class MinHeap(
    var root: BinaryNode<Int>
) {
    fun insert(value: Int) {
        val node = BinaryNode(value)

        val nodes = LinkedList<BinaryNode<Int>>()
        nodes.push(root)
        var current: BinaryNode<Int>?

        while (nodes.isNotEmpty()) {
            current = nodes.remove()

            if (current.left == null) {
                current.left = node
                node.parent = current
                break
            } else if (current.right == null) {
                current.right = node
                node.parent = current
                break
            }

            nodes.add(current.left!!)
            nodes.add(current.right!!)
        }

        bubbleUp(node)
    }

    private fun bubbleUp(node: BinaryNode<Int>) {
        node.parent?.let { parent ->
            if (parent.value > node.value) {
                swap(parent, node)
                bubbleUp(parent)
            }
        } ?: return
    }

    private fun swap(node1: BinaryNode<Int>, node2: BinaryNode<Int>) {
        val temp = node1.value
        node1.value = node2.value
        node2.value = temp
    }
}
