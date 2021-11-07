package tree.bst.rotations

import tree.bst.Node

class LeftRight : Rotation {
    override fun rotate(node: Node) {
        val child = node.left!!
        val grandChild = child.right!!

        adjustParentChild(node, grandChild)

        grandChild.parent = node.parent
        grandChild.left = child
        grandChild.right = node

        child.parent = grandChild
        child.right = null

        node.parent = grandChild
        node.left = null
        node.right = null
    }
}
