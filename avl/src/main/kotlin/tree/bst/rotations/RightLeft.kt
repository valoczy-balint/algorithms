package tree.bst.rotations

import tree.bst.Node

class RightLeft : Rotation {
    override fun rotate(node: Node) {
        val child = node.right!!
        val grandChild = child.left!!

        adjustParentChild(node, grandChild)

        grandChild.parent = node.parent
        grandChild.right = child
        grandChild.left = node

        child.parent = grandChild
        child.left = null

        node.parent = grandChild
        node.left = null
        node.right = null
    }
}
