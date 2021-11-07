package tree.bst.rotations

import tree.bst.Node

class Left : Rotation {
    override fun rotate(node: Node) {
        val child = node.right
        val grandChild = child?.left

        node.parent?.right = child

        child?.parent = node.parent

        node.parent = child
        node.right = grandChild

        child?.left = node
    }
}
