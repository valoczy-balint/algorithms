package dfs

import tree.Node
import java.util.Stack

class Dfs {

    fun preOrder(root: Node, target: Node): Boolean {
        println("Preorder searching for: ${target.value}")

        val stack = Stack<Node>()

        stack.push(root)

        while (stack.isNotEmpty()) {
            val current = stack.pop()
            println(current.value)
            if (current.value == target.value) {
                return true
            } else {
                current.children.reversed().forEach {
                    stack.push(it)
                }
            }
        }
        return false
    }

    fun postOrder(root: Node, target: Node): Boolean {
        println("Postorder searching for: ${target.value}")
        return postOrderRecursive(root, target)
    }

    private fun postOrderRecursive(root: Node, target: Node): Boolean {

        root.children.forEach {
            if (postOrderRecursive(it, target)) {
                return true
            }
        }
        println(root.value)
        return root.value == target.value
    }
}
