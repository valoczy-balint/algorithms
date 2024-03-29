package tree.bst

import tree.bst.rotations.Rotations
import tree.bst.rotations.rotate
import kotlin.math.abs
import kotlin.math.max

class Node(
    var value: Int,
) {
    var left: Node? = null
    var right: Node? = null
    var parent: Node? = null

    fun insert(node: Node): Node {
        if (node.parent != null) {
            throw RuntimeException("Insert can only be called on root node")
        }
        insertRecursive(node)
        return findRoot()
    }

    private fun insertRecursive(node: Node) {
        if (value == node.value) {
            throw IllegalArgumentException("Value already added")
        }

        if (value < node.value) {
            if (right == null) {
                right = node
                node.parent = this
                findUnbalancedParent()?.let {
                    val rotation = determineRotation(it)
                    rotation.rotate(it)
                }
                this.parent?.let { null }
            } else {
                right!!.insertRecursive(node)    //Not good for multithreading
            }
        } else if (value > node.value) {
            if (left == null) {
                left = node
                node.parent = this
                findUnbalancedParent()?.let {
                    determineRotation(it).rotate(it)
                }
                this.parent?.let { null }
            } else {
                left!!.insertRecursive(node)
            }
        }
    }

    private fun findUnbalancedParent(): Node? {
        val longestLeft = left?.longestPath() ?: 0
        val longestRight = right?.longestPath() ?: 0

        return if (abs(longestRight - longestLeft) > 1) this
        else parent?.findUnbalancedParent()
    }

    //TODO memoize
    private fun longestPath(): Int {
        val longestLeft = left?.longestPath() ?: 0
        val longestRight = right?.longestPath() ?: 0

        return max(longestLeft, longestRight) + 1
    }

    private fun determineRotation(node: Node): Rotations {
        val longestPathOnLeftChild = node.left?.longestPath() ?: 0
        val longestPathOnRightChild = node.right?.longestPath() ?: 0

        if (longestPathOnLeftChild > longestPathOnRightChild) {
            val longestPathOnLeftGrandChild = node.left?.left?.longestPath() ?: 0
            val longestPathOnRightGrandChild = node.left?.right?.longestPath() ?: 0
            return if (longestPathOnLeftGrandChild > longestPathOnRightGrandChild) {
                Rotations.R
            } else if (longestPathOnLeftGrandChild < longestPathOnRightGrandChild) {
                Rotations.LR
            } else throw RuntimeException("Invalid tree")
        } else if (longestPathOnLeftChild < longestPathOnRightChild) {
            val longestPathOnLeftGrandChild = node.right?.left?.longestPath() ?: 0
            val longestPathOnRightGrandChild = node.right?.right?.longestPath() ?: 0
            return if (longestPathOnLeftGrandChild > longestPathOnRightGrandChild) {
                Rotations.RL
            } else if (longestPathOnLeftGrandChild < longestPathOnRightGrandChild) {
                Rotations.L
            } else throw RuntimeException("Invalid tree")
        } else throw RuntimeException("Invalid tree")
    }

    private fun findRoot(): Node =
        this.parent?.findRoot() ?: this
}

