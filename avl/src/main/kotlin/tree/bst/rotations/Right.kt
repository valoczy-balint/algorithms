package tree.bst.rotations

import tree.bst.Node

class Right : Rotation {
    override fun rotate(node: Node) {
        val child = node.left
        val grandChild = child?.right

        node.parent?.left = child

        child?.parent = node.parent

        node.parent = child
        node.left = grandChild

        child?.right = node
    }
}
