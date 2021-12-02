package heap

import tree.BinaryNode
import java.util.LinkedList

/**
 * Not concurrent
 */
class MinHeapTree<T : Comparable<T>>(
    var root: BinaryNode<T>? = null
) : Collection<T> {
    private var lastInserted: BinaryNode<T>? = root
    override var size: Int = 1

    fun delete(): T {
        root?.let { it ->
            if(it == lastInserted) {
                val result = lastInserted!!.value
                root = null
                lastInserted = null
                size--
                return result
            }
            val result = it.value
            it.value = lastInserted!!.value
            lastInserted!!.parent?.let {
                if (it.left == lastInserted) {
                    it.left = null
                } else {
                    it.right = null
                }
            }
            lastInserted!!.parent = null

            trickleDown(it)
            lastInserted = findLastInserted()

            size--
            return result
        } ?: throw RuntimeException("Heap is empty")
    }

    private fun trickleDown(node: BinaryNode<T>) {
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

    fun insert(value: T) {
        val node = BinaryNode(value)

        val nodes = LinkedList<BinaryNode<T>>()
        nodes.push(root)
        var current: BinaryNode<T>?

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
        size++
    }

    private fun findLastInserted(): BinaryNode<T> {
        val queue = LinkedList<BinaryNode<T>>()
        queue.add(root!!)
        val listRepresentation = ArrayList<BinaryNode<T>>()
        while (queue.isNotEmpty()) {
            val node = queue.remove()
            node.left?.let {
                queue.add(it)
            }
            node?.right?.let {
                queue.add(it)
            }
            listRepresentation.add(node)
        }

        return listRepresentation[listRepresentation.size - 1]
//            if (node.right != null) {
//                val right = node.right
//
//                // Right has both children
//                if (right?.left != null && right.right != null) {
//                    queue.add(right)
//                    continue
//                }
//
//                // Right has left child only
//                if (right?.left != null && right.right == null) {
//                    return right.left!!
//                }
//
//                // Right has no children
//                if (right?.left == null && right?.right == null) {
//                    val left = node.left
//
//                    // Left has right child
//                    if (left?.right != null) {
//                        return left.right!!
//                        // Left has left child
//                    } else if (left?.left != null) {
//                        return left.left!!
//                        // Left has no children
//                    } else {
//                        return right!!
//                    }
//                }
//
//            } else if(node.left != null) {
//                return node.left!!
//            } else {
//                return node
//            }
//        }
//        throw RuntimeException("Last inserted node not found")
    }

    private fun bubbleUp(node: BinaryNode<T>) {
        node.parent?.let { parent ->
            if (parent.value > node.value) {
                swap(parent, node)
                bubbleUp(parent)
            }
        } ?: return
    }

    private fun swap(node1: BinaryNode<T>, node2: BinaryNode<T>) {
        val temp = node1.value
        node1.value = node2.value
        node2.value = temp
    }

    // List representation
    override fun toString(): String {
        return root?.let {
            val queue = LinkedList<BinaryNode<T>>()
            val result = mutableListOf<T>()

            queue.add(it)

            while (queue.isNotEmpty()) {
                val current = queue.remove()
                current.left?.let {
                    queue.add(it)
                }
                current.right?.let {
                    queue.add(it)
                }
                result.add(current.value)
            }

            "[${result.joinToString(", ")}]"
        } ?: "[]"
    }

    override fun contains(element: T): Boolean {
        throw RuntimeException("Not implemented")
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        throw RuntimeException("Not implemented")
    }

    override fun isEmpty() = root == null

    override fun iterator(): Iterator<T> {
        throw RuntimeException("Not implemented")
    }
}
