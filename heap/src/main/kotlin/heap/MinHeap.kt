package heap

import tree.BinaryNode
import java.util.LinkedList

class MinHeap(
    var root: BinaryNode<Int>
) {
    private var lastInserted: BinaryNode<Int> = root

    fun delete(): Int {
        root.value = lastInserted.value
        lastInserted.parent?.let {
            if(it.left == lastInserted) {
                it.left = null
            } else {
                it.right = null
            }
        }
        lastInserted.parent = null

        trickleDown(root)
        lastInserted = findLastInserted()

        return root.value
    }


    private fun trickleDown(node: BinaryNode<Int>) {
        node.left?.let { left ->
            node.right?.let { right ->                       //Left and right exists
                if (node.value > left.value
                    && node.value > right.value
                ) {
                    if (left.value <= right.value) {
                        swap(left, node)
                        trickleDown(left)
                    } else if (left.value > right.value) {
                        swap(right, node)
                        trickleDown(right)
                    }
                } else if (node.value > left.value) {
                    swap(left, node)
                    trickleDown(left)
                } else if (node.value > right.value) {
                    swap(right, node)
                    trickleDown(right)
                }
            } ?: if (node.value > left.value) {             //Only left exists
                swap(left, node)
                trickleDown(left)
            }
        } ?: node.right?.let { right ->
            if (node.value > right.value) {                 //Only right exists
                swap(right, node)
                trickleDown(right)
            }
        }
    }


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
        lastInserted = node
    }

    private fun findLastInserted(): BinaryNode<Int> {
        val queue = LinkedList<BinaryNode<Int>>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val node = queue.remove()

            if (node.right != null) {
                val right = node.right

                // Right has both children
                if (right?.left != null && right.right != null) {
                    queue.add(right)
                    continue
                }

                // Right has left child only
                if (right?.left != null && right.right == null) {
                    return right.left!!
                }

                // Right has no children
                if (right?.left == null && right?.right == null) {
                    val left = node.left

                    // Left has right child
                    if (left?.right != null) {
                        return left.right!!
                        // Left has left child
                    } else if (left?.left != null) {
                        return left.left!!
                        // Left has no children
                    } else {
                        return right!!
                    }
                }

            }
        }
        throw RuntimeException("Last inserted node not found")
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

    // List representation
    override fun toString(): String {
        val queue = LinkedList<BinaryNode<Int>>()
        val result = mutableListOf<Int>()

        queue.add(root)

        while(queue.isNotEmpty()) {
            val current = queue.remove()
            current.left?.let {
                queue.add(it)
            }
            current.right?.let {
                queue.add(it)
            }
            result.add(current.value)
        }


        return "[${result.joinToString(", ")}]"
    }


}
