package bfs

import tree.Node
import java.util.LinkedList

class Bfs {
    fun findInTree(root: Node, target: Node): Boolean {
        val queue = LinkedList<Node>()

        queue.add(root)

        var current: Node?

        while (queue.isNotEmpty()) {
            current = queue.remove()
            if (current.value == target.value) {
                return true
            }
            current.children.forEach {
                queue.add(it)
            }
        }
        return false
    }
}
